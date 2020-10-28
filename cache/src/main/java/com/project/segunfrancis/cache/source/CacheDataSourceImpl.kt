package com.project.segunfrancis.cache.source

import com.project.segunfrancis.cache.dao.CoinsDao
import com.project.segunfrancis.cache.mapper.CoinsMapper
import com.project.segunfrancis.data.model.CoinsData
import com.project.segunfrancis.data.source.CacheDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by SegunFrancis
 */

class CacheDataSourceImpl @Inject constructor(
    private val dao: CoinsDao,
    private val coinsMapper: CoinsMapper
) : CacheDataSource {
    override fun addCoins(coins: List<CoinsData>): Flow<Unit> {
        return flow {
            emit(dao.addCoins(coins.map {
                coinsMapper.mapToCacheLayer(it)
            }))
        }
    }

    override fun getCoins(): Flow<List<CoinsData>> {
        return dao.getCoins().map { coins ->
            coins.map {
                coinsMapper.mapToDataLayer(it)
            }
        }
    }
}