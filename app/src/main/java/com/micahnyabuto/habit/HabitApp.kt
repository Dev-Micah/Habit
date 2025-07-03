package com.micahnyabuto.habit

import android.app.Application
import com.micahnyabuto.habit.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import java.util.logging.Level

class HabitApp: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(org.koin.core.logger.Level.DEBUG)
            androidContext(this@HabitApp)
            modules(appModule)
        }
    }
}