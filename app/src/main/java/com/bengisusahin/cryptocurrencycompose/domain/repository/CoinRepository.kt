package com.bengisusahin.cryptocurrencycompose.domain.repository

import com.bengisusahin.cryptocurrencycompose.data.remote.dto.CoinDetailDto
import com.bengisusahin.cryptocurrencycompose.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}