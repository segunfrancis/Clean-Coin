package com.project.segunfrancis.remote.source

import com.project.segunfrancis.data.model.BaseData
import com.project.segunfrancis.data.source.RemoteDataSource
import com.project.segunfrancis.remote.api.CoinsApi
import com.project.segunfrancis.remote.mapper.BaseMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by SegunFrancis
 */

class RemoteDataSourceImpl @Inject constructor(
    private val api: CoinsApi,
    private val baseMapper: BaseMapper
) :
    RemoteDataSource {

    override fun getCoins(): Flow<BaseData> {
        return flow {
            emit(
                baseMapper.mapToDataLayer(api.getCoins())
            )
        }
    }
}