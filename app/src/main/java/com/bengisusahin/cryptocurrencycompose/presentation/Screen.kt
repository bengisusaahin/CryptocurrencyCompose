package com.bengisusahin.cryptocurrencycompose.presentation

// sealed class uses the keyword sealed to restrict the class hierarchy.
// This means that all subclasses of a sealed class are known at compile time.
sealed class Screen(val route: String) {
    object CoinListScreen: Screen("coin_list_screen")
    object CoinDetailScreen: Screen("coin_detail_screen")
}