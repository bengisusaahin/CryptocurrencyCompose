package com.bengisusahin.cryptocurrencycompose.presentation.coin_detail

import com.bengisusahin.cryptocurrencycompose.domain.model.Coin
import com.bengisusahin.cryptocurrencycompose.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
