package com.project.segunfrancis.cleancoin.ui.coinlist

import com.project.segunfrancis.data.repository.CacheRepositoryImpl
import com.project.segunfrancis.data.repository.RemoteRepositoryImpl
import com.project.segunfrancis.domain.repository.CacheRepository
import com.project.segunfrancis.domain.repository.RemoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

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
}