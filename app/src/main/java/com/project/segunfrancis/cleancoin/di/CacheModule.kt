package com.project.segunfrancis.cleancoin.di

import android.content.Context
import androidx.room.Room
import com.project.segunfrancis.cache.db.CoinsDatabase
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
object DatabaseModule {
    @Provides
    @Singleton
    fun dataBase(@ApplicationContext context: Context): CoinsDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            CoinsDatabase::class.java,
            "coins_database"
        ).build()
    }
}
