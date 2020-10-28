package com.project.segunfrancis.cleancoin.di

import android.content.Context
import androidx.room.Room
import com.project.segunfrancis.cache.dao.CoinsDao
import com.project.segunfrancis.cache.db.CoinsDatabase
import com.project.segunfrancis.cache.source.CacheDataSourceImpl
import com.project.segunfrancis.data.source.CacheDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 * Created by SegunFrancis
 */

@Module
@InstallIn(ApplicationComponent::class)
abstract class CacheModule {

    @Binds
    @Singleton
    abstract fun cacheDataSource(cacheDataSource: CacheDataSourceImpl): CacheDataSource
}

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun dataBase(@ApplicationContext context: Context): CoinsDatabase {
        return synchronized(CoinsDatabase::class.java) {
            Room.databaseBuilder(
                context.applicationContext,
                CoinsDatabase::class.java,
                "coins_database"
            ).build()
        }
    }
}
