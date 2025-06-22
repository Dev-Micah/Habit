package com.micahnyabuto.habit.core.data.repository

import com.micahnyabuto.habit.core.data.local.HabitDao
import com.micahnyabuto.habit.core.data.local.HabitEntity
import kotlinx.coroutines.flow.Flow

interface HabitRepository {
    fun allHabits(): Flow<List<HabitEntity>>

    suspend fun insertHabit(habit: HabitEntity)
    suspend fun updateHabit(habit: HabitEntity)
    suspend fun deleteHabit(habit: HabitEntity)
}

class HabitRepositoryImpl(private val habitDao: HabitDao): HabitRepository {

    override fun allHabits(): Flow<List<HabitEntity>> = habitDao.allHabits()


    override suspend fun insertHabit(habit: HabitEntity) {
        habitDao.insertHabit(habit)
    }


    override suspend fun updateHabit(habit: HabitEntity) {
        habitDao.updateHabit(habit)
    }

    override suspend fun deleteHabit(habit: HabitEntity) {
        habitDao.deleteHabit(habit)
    }
}