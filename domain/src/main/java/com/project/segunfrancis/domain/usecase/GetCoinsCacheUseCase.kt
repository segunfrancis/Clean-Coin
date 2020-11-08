package com.project.segunfrancis.domain.usecase

import com.project.segunfrancis.domain.model.CoinsDomain
import com.project.segunfrancis.domain.repository.CacheRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by SegunFrancis
 */

class GetCoinsCacheUseCase @Inject constructor(
    private val cacheRepository: CacheRepository,
    private val dispatcher: CoroutineDispatcher
) {

    fun execute(): Flow<List<CoinsDomain>> {
        return cacheRepository.getCoins().flowOn(dispatcher)
    }
}