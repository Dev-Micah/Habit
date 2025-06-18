package com.micahnyabuto.habit.core.data.repository

import com.micahnyabuto.habit.core.data.local.HabitDao
import com.micahnyabuto.habit.core.data.local.HabitEntity
import kotlinx.coroutines.flow.Flow

interface HabitRepository {
    val allHabits: Flow<List<HabitEntity>>

    suspend fun insertHabit(habit: HabitEntity)
    suspend fun updateHabit(habit: HabitEntity)
    suspend fun deleteHabit(habit: HabitEntity)
}

class HabitRepositoryImpl(private val habitDao: HabitDao) {

    val allHabits: Flow<List<HabitEntity>> = habitDao.getAllHabits()


    suspend fun insertHabit(habit: HabitEntity) {
        habitDao.insertHabit(habit)
    }


    suspend fun updateHabit(habit: HabitEntity) {
        habitDao.updateHabit(habit)
    }

    suspend fun deleteHabit(habit: HabitEntity) {
        habitDao.deleteHabit(habit)
    }
}