package com.bengisusahin.cryptocurrencycompose.domain.use_case.get_coins

import com.bengisusahin.cryptocurrencycompose.common.Resource
import com.bengisusahin.cryptocurrencycompose.data.remote.dto.toCoin
import com.bengisusahin.cryptocurrencycompose.domain.model.Coin
import com.bengisusahin.cryptocurrencycompose.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
){
    // We used flow because we want to emit multiple values over a period of time
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        // if our repository or api can't even talk to the actual remote api for example no internet connection
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}