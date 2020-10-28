package com.project.segunfrancis.data.source

import com.project.segunfrancis.data.model.BaseData
import kotlinx.coroutines.flow.Flow

/**
 * Created by SegunFrancis
 */

interface RemoteDataSource {
    fun getCoins(): Flow<BaseData>
}