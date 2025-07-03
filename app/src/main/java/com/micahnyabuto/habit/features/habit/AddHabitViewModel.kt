package com.micahnyabuto.habit.features.habit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.micahnyabuto.habit.core.data.local.HabitEntity
import com.micahnyabuto.habit.core.data.repository.HabitRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class AddHabitViewModel(
    private val habitRepository: HabitRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(HabitUiState())
    val uiState: StateFlow<HabitUiState> = _uiState

    init {
        getAllHabits()
    }

    fun getAllHabits() {
        viewModelScope.launch {
            habitRepository.allHabits()
                .onStart {
                    _uiState.value = _uiState.value.copy(isLoading = true, error = null)
                }
                .catch { e ->
                    _uiState.value = _uiState.value.copy(isLoading = false, error = e.message)
                }
                .collect { habits ->
                    _uiState.value = HabitUiState(isLoading = false, habits = habits)
                }
        }
    }

    fun insertHabit(habit: HabitEntity) {
        viewModelScope.launch {
            try {
                _uiState.value = _uiState.value.copy(isLoading = true)
                habitRepository.insertHabit(habit)
                _uiState.value = _uiState.value.copy(isLoading = false)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(isLoading = false, error = e.message)
            }
        }
    }

    fun updateHabit(habit: HabitEntity) {
        viewModelScope.launch {
            try {
                habitRepository.updateHabit(habit)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(error = e.message)
            }
        }
    }

    fun deleteHabit(habit: HabitEntity) {
        viewModelScope.launch {
            try {
                habitRepository.deleteHabit(habit)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(error = e.message)
            }
        }
    }


    data class HabitUiState(
        val isLoading: Boolean = false,
        val habits: List<HabitEntity> = emptyList(),
        val error: String? = null
    )

}