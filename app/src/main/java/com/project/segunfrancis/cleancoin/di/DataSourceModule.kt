package com.project.segunfrancis.cleancoin.di

import com.project.segunfrancis.cache.source.CacheDataSourceImpl
import com.project.segunfrancis.data.source.CacheDataSource
import com.project.segunfrancis.data.source.RemoteDataSource
import com.project.segunfrancis.remote.source.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * Created by SegunFrancis
 */

@Module
@InstallIn(ApplicationComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun cacheDataSource(cacheDataSource: CacheDataSourceImpl): CacheDataSource

    @Binds
    @Singleton
    abstract fun remoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource
}