package com.project.segunfrancis.remote.model

/**
 * Created by SegunFrancis
 */

data class CoinsResponse(
    val id: Int,
    val symbol: String,
    val name: String,
    val description: String,
    val iconUrl: String,
    val price: String
)