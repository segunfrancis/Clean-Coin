package com.project.segunfrancis.cache.mapper

/**
 * Created by SegunFrancis
 */

interface Mapper<C, D> {
    fun mapToDataLayer(type: C): D
    fun mapToCacheLayer(type: D): C
}