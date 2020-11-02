package com.project.segunfrancis.data.model

/**
 * Created by SegunFrancis
 */

data class CoinsData(
    val id: Int,
    val symbol: String,
    val name: String,
    val description: String?,
    val iconUrl: String,
    val price: String
)