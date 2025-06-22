package com.micahnyabuto.habit

import android.app.Application
import com.micahnyabuto.habit.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HabitApp: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@HabitApp)
            modules(appModule)
        }
    }
}