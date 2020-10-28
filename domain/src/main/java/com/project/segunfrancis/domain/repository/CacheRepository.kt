package com.project.segunfrancis.domain.repository

import com.project.segunfrancis.domain.model.CoinsDomain
import kotlinx.coroutines.flow.Flow

/**
 * Created by SegunFrancis
 */

interface CacheRepository {
    fun addCoins(coins: List<CoinsDomain>): Flow<Unit>

    fun getCoins(): Flow<List<CoinsDomain>>
}