package com.micahnyabuto.habit.di

import androidx.room.Room
import com.micahnyabuto.habit.core.data.local.HabitDatabase
import com.micahnyabuto.habit.core.data.repository.HabitRepository
import com.micahnyabuto.habit.core.data.repository.HabitRepositoryImpl
import com.micahnyabuto.habit.features.habit.AddHabitViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            HabitDatabase::class.java,
            "habits"
        ).build()
    }

    single { get<HabitDatabase>().habitDao() }

    single<HabitRepository> { HabitRepositoryImpl(get()) }

    viewModel {
        AddHabitViewModel(get())
    }



}