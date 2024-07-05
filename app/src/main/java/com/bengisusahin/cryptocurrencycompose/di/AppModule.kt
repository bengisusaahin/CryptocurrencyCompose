package com.bengisusahin.cryptocurrencycompose.di

import com.bengisusahin.cryptocurrencycompose.common.Constants
import com.bengisusahin.cryptocurrencycompose.data.remote.CoinPaprikaApi
import com.bengisusahin.cryptocurrencycompose.data.repository.CoinRepositoryImpl
import com.bengisusahin.cryptocurrencycompose.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
// InstallIn means determine how long these dependencies will live
// SingletonComponent means these dependencies will live as long as the application is alive
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    // Singleton means this dependency will be created only once and will be used throughout the application
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}