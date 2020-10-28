package com.project.segunfrancis.data.source

import javax.inject.Inject

/**
 * Created by SegunFrancis
 */

class DataSourceFactory @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val cacheDataSource: CacheDataSource
) {
    fun remote() = remoteDataSource
    fun cache() = cacheDataSource
}