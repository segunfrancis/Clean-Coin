package com.project.segunfrancis.cleancoin.ui.coinlist

import com.project.segunfrancis.cleancoin.mapper.BaseMapper
import com.project.segunfrancis.cleancoin.mapper.CoinMapper
import com.project.segunfrancis.data.repository.CacheRepositoryImpl
import com.project.segunfrancis.data.repository.RemoteRepositoryImpl
import com.project.segunfrancis.domain.repository.CacheRepository
import com.project.segunfrancis.domain.repository.RemoteRepository
import com.project.segunfrancis.domain.usecase.AddCoinsUseCase
import com.project.segunfrancis.domain.usecase.GetCoinsCacheUseCase
import com.project.segunfrancis.domain.usecase.GetCoinsRemoteUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Inject

/**
 * Created by SegunFrancis
 */

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class CoinListModule {

    @Binds
    abstract fun cacheRepository(cacheRepositoryImpl: CacheRepositoryImpl): CacheRepository

    @Binds
    abstract fun remoteRepository(remoteRepositoryImpl: RemoteRepositoryImpl): RemoteRepository

    @Inject
    lateinit var baseMapper: BaseMapper

    @Inject
    lateinit var coinMapper: CoinMapper

    @Binds
    abstract fun getCoinsCacheUseCase(cacheRepository: CacheRepository): GetCoinsCacheUseCase

    @Binds
    abstract fun getCoinsRemoteUseCase(remoteRepository: RemoteRepository): GetCoinsRemoteUseCase

    @Binds
    abstract fun addCoinsUseCase(cacheRepository: CacheRepository): AddCoinsUseCase
}