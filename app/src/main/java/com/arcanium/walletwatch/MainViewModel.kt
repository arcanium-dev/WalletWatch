package com.arcanium.walletwatch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arcanium.walletwatch.feature.core.domain.CheckIfUserIsNewUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val checkIfUserIsNew: CheckIfUserIsNewUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(MainActivityUiState())
    val uiState = _uiState.asStateFlow()

    fun setUp() = viewModelScope.launch {
        // TODO - setup any business logic
        checkIfUserIsNew.invoke()
        // To be removed, temporarily simulates any business logic being done
        delay(2000L)
        _uiState.update { it.copy(showSplashScreen = false) }
    }
}