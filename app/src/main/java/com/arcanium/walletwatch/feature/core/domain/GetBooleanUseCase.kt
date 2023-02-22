package com.arcanium.walletwatch.feature.core.domain

import javax.inject.Inject

class GetBooleanUseCase @Inject constructor(
    private val preferencesRepository: PreferencesRepository
) {
    /**
     * Invokes the PreferencesRepository's suspended getBoolean function that will return a boolean associated with the provided key string if it exists otherwise null.
     * @param key - The key to be queried.
     * @param defaultValue - The value that should be returned if the provided key does not exist. This is null by default but can be set to true or false.
     */
    suspend operator fun invoke(key: String, defaultValue: Boolean? = null): Boolean? {
        return preferencesRepository.getBoolean(key) ?: defaultValue
    }
}