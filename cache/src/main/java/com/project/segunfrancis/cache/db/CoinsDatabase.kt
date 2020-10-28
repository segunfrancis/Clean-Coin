package com.project.segunfrancis.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.segunfrancis.cache.dao.CoinsDao
import com.project.segunfrancis.cache.model.CoinsCache

/**
 * Created by SegunFrancis
 */

@Database(entities = [CoinsCache::class], version = 1, exportSchema = false)
abstract class CoinsDatabase : RoomDatabase() {
    abstract fun coinsDao(): CoinsDao
}