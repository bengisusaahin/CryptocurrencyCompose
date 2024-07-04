package com.bengisusahin.cryptocurrencycompose.domain.model

import com.bengisusahin.cryptocurrencycompose.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId: String,
    val name: String,
    val symbol: String,
    val description: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)
