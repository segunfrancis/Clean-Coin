package com.project.segunfrancis.data.repository

import com.project.segunfrancis.data.mapper.BaseMapper
import com.project.segunfrancis.data.source.DataSourceFactory
import com.project.segunfrancis.domain.model.BaseDomain
import com.project.segunfrancis.domain.repository.RemoteRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by SegunFrancis
 */

@ExperimentalCoroutinesApi
class RemoteRepositoryImpl @Inject constructor(
    private val dataSourceFactory: DataSourceFactory,
    private val baseMapper: BaseMapper
) :
    RemoteRepository {

    override fun getCoins(): Flow<BaseDomain> {
        return dataSourceFactory.remote().getCoins().map {
            baseMapper.mapToDomainLayer(it)
        }
    }
}