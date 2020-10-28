package com.project.segunfrancis.data.source

import com.project.segunfrancis.data.model.CoinsData
import kotlinx.coroutines.flow.Flow

/**
 * Created by SegunFrancis
 */

interface CacheDataSource {
    fun addCoins(coins: List<CoinsData>): Flow<Unit>
    fun getCoins(): Flow<List<CoinsData>>
}