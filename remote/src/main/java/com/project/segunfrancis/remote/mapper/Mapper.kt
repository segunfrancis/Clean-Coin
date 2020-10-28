package com.project.segunfrancis.remote.mapper

/**
 * Created by SegunFrancis
 */

interface Mapper<in R, out D> {
    fun mapToDataLayer(type: R): D
}