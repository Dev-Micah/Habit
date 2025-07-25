package com.micahnyabuto.habit.core.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHabit (habit: HabitEntity)

    @Update
    suspend fun updateHabit(habit: HabitEntity)

    @Delete
    suspend fun deleteHabit(habit: HabitEntity)

    @Query("SELECT * FROM habits ORDER BY id ASC ")
    fun allHabits (): Flow<List<HabitEntity>>
}