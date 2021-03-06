package com.project.segunfrancis.domain.usecase

import com.project.segunfrancis.domain.model.BaseDomain
import com.project.segunfrancis.domain.repository.RemoteRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by SegunFrancis
 */

class GetCoinsRemoteUseCase @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val dispatcher: CoroutineDispatcher
) {

    fun execute(): Flow<BaseDomain> {
        return remoteRepository.getCoins().flowOn(dispatcher)
    }
}