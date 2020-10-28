package com.project.segunfrancis.data.mapper

/**
 * Created by SegunFrancis
 */
interface Mapper<I, O> {
    fun mapToDomainLayer(type: I): O
    fun mapToDataLayer(type: O): I {
        throw UnsupportedOperationException()
    }
}