package com.project.segunfrancis.cleancoin.mapper

/**
 * Created by SegunFrancis
 */

interface Mapper<D, A> {
    fun mapToDomainLayer(type: A): D
    fun mapToAppLayer(type: D): A
}