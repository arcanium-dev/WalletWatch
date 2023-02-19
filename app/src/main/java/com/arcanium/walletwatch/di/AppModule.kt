package com.arcanium.walletwatch.di

import android.content.Context
import com.arcanium.walletwatch.feature.core.data.DataStoreRepository
import com.arcanium.walletwatch.feature.core.domain.PreferencesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDataStoreRepository(@ApplicationContext context: Context): PreferencesRepository = DataStoreRepository(context)
}