package com.arcanium.walletwatch.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MainActivityUiState())
    val uiState = _uiState.asStateFlow()

    fun setUp() = viewModelScope.launch {
        // TODO - setup any business logic
        delay(2000L)
        _uiState.update { it.copy(showSplashScreen = false) } // To be removed, temporarily simulates any business logic being done
    }
}