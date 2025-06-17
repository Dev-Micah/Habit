package com.micahnyabuto.habit.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habits")
data class HabitEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int =0,
    val content: String,
    val createdAt: Long
)
