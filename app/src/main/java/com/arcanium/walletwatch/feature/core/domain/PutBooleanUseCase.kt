package com.arcanium.walletwatch.feature.core.domain

import javax.inject.Inject

class PutBooleanUseCase @Inject constructor(
    private val preferencesRepository: PreferencesRepository
) {
    suspend operator fun invoke(key: String, value: Boolean) {
        preferencesRepository.putBoolean(key, value)
    }
}