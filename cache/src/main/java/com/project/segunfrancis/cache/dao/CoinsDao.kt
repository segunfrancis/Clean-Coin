package com.project.segunfrancis.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.project.segunfrancis.cache.model.CoinsCache
import kotlinx.coroutines.flow.Flow

/**
 * Created by SegunFrancis
 */

@Dao
interface CoinsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCoins(coins: List<CoinsCache>)

    @Query("SELECT * FROM coins_table")
    fun getCoins(): Flow<List<CoinsCache>>
}