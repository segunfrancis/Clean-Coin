package com.project.segunfrancis.data.repository

import com.project.segunfrancis.data.mapper.CoinsMapper
import com.project.segunfrancis.data.source.DataSourceFactory
import com.project.segunfrancis.domain.model.CoinsDomain
import com.project.segunfrancis.domain.repository.CacheRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by SegunFrancis
 */

class CacheRepositoryImpl @Inject constructor(
    private val dataSourceFactory: DataSourceFactory,
    private val coinsMapper: CoinsMapper
) :
    CacheRepository {
    override fun addCoins(coins: List<CoinsDomain>): Flow<Unit> {
        return dataSourceFactory.cache().addCoins(coins.map {
            coinsMapper.mapToDomainLayer(it)
        })
    }

    override fun getCoins(): Flow<List<CoinsDomain>> {
        return dataSourceFactory.cache().getCoins().map { coins ->
            coins.map {
                coinsMapper.mapToDataLayer(it)
            }
        }
    }
}