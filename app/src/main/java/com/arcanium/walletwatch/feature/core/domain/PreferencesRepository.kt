package com.arcanium.walletwatch.feature.core.domain

interface PreferencesRepository {

    /**
     * Asynchronously persists a key-value pair in the device's preference file.
     * @param key - The string that the value argument should saved with.
     * @param value - The value to be saved with the provided key string
     */
    suspend fun putBoolean(key: String, value: Boolean)

    /**
     * Asynchronously gets the boolean associated with the provided key string in the argument.
     * Should this key not exist, this function will return null.
     * @param - key string that should be queried.
     * @return Boolean? that will default to null if it doesn't exist.
     */
    suspend fun getBoolean(key: String): Boolean?

    // All keys for persistent preferences should be stored in this companion object.
    companion object {
        const val IS_USER_BRAND_NEW = "is_user_brand_new"
    }
}