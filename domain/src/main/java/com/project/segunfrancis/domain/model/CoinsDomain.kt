package com.project.segunfrancis.domain.model

/**
 * Created by SegunFrancis
 */

data class CoinsDomain(
    val id: Int,
    val symbol: String,
    val name: String,
    val description: String?,
    val iconUrl: String,
    val price: String
)