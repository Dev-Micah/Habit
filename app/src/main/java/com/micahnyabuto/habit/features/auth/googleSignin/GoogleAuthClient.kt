package com.micahnyabuto.habit.features.auth.googleSignin

import android.content.Context
import android.content.Intent
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.result.ActivityResult
import androidx.activity.result.IntentSenderRequest
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.micahnyabuto.habit.R

class GoogleAuthClient(private val context: Context) {

    private val oneTapClient = Identity.getSignInClient(context)

    private val signInRequest = BeginSignInRequest.builder()
        .setGoogleIdTokenRequestOptions(
            BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                .setSupported(true)
                .setServerClientId(context.getString(R.string.web_client_id))
                .setFilterByAuthorizedAccounts(false)
                .build()
        )
        .setAutoSelectEnabled(true)
        .build()

    fun launch(
        launcher: ManagedActivityResultLauncher<IntentSenderRequest, ActivityResult>,
        onError: (String) -> Unit
    ) {
        oneTapClient.beginSignIn(signInRequest)
            .addOnSuccessListener { result ->
                val intentSenderRequest = IntentSenderRequest.Builder(result.pendingIntent).build()
                launcher.launch(intentSenderRequest)
            }
            .addOnFailureListener {
                onError(it.localizedMessage ?: "Google Sign-In failed")
            }
    }

    fun handleResult(
        intent: Intent?,
        onSuccess: (FirebaseUser) -> Unit,
        onError: (String) -> Unit
    ) {
        try {
            val credential = oneTapClient.getSignInCredentialFromIntent(intent)
            val idToken = credential.googleIdToken
            val firebaseCredential = GoogleAuthProvider.getCredential(idToken, null)

            FirebaseAuth.getInstance().signInWithCredential(firebaseCredential)
                .addOnSuccessListener { result ->
                    onSuccess(result.user!!)
                }
                .addOnFailureListener {
                    onError(it.localizedMessage ?: "Firebase Sign-In failed")
                }

        } catch (e: Exception) {
            onError(e.localizedMessage ?: "Unexpected error")
        }
    }
}

