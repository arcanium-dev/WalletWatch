package com.arcanium.walletwatch.feature.core.domain

import javax.inject.Inject

class CheckIfUserIsNewUseCase @Inject constructor(
    private val preferencesRepository: PreferencesRepository
) {
    /**
     * Suspend function that determines whether the client in the app is a brand new user or not.
     * If a client has never completed the app onboarding flow before then this function will return true.
     * Should the preferences file contain no data regarding the client having completed onboarding, it will assume that this is the first time that the user has downloaded the app
     * and set the flag to determine if a user is brand new, to true.
     * @return Boolean based on whether the user is brand new
     */
    suspend operator fun invoke(): Boolean {
        val isBrandNew = preferencesRepository.getBoolean(PreferencesRepository.IS_USER_BRAND_NEW)
        return if (isBrandNew == null) {
            // TODO - make an api call to determine whether the user has completed onboarding before
            preferencesRepository.putBoolean(PreferencesRepository.IS_USER_BRAND_NEW, true)
            // Temporarily return true in null case until api is setup
            true
        } else {
            isBrandNew
        }
    }
}