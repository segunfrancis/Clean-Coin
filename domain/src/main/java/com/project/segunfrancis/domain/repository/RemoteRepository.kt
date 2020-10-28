package com.project.segunfrancis.domain.repository

import com.project.segunfrancis.domain.model.BaseDomain
import kotlinx.coroutines.flow.Flow

/**
 * Created by SegunFrancis
 */
interface RemoteRepository {
    fun getCoins(): Flow<BaseDomain>
}