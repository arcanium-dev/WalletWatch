package com.arcanium.walletwatch.feature.core.domain

interface PreferencesRepository {
    suspend fun putBoolean(key: String, value: Boolean)
    suspend fun getBoolean(key: String): Boolean?
}