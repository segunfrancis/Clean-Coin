package com.project.segunfrancis.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by SegunFrancis
 */

@Entity(tableName = "coins_table")
data class CoinsCache(
    @PrimaryKey
    val id: Int,
    val symbol: String,
    val name: String,
    val description: String?,
    val iconUrl: String,
    val price: String
)