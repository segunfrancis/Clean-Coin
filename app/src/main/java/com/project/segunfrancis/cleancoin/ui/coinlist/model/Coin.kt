package com.project.segunfrancis.cleancoin.ui.coinlist.model

/**
 * Created by SegunFrancis
 */

data class Coin(
    val id: Int,
    val symbol: String,
    val name: String,
    val description: String?,
    val iconUrl: String,
    val price: String
)