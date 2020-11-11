package com.project.segunfrancis.cleancoin

import android.app.Application
import com.project.segunfrancis.cleancoin.timber.CoinTimberTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * Created by SegunFrancis
 */

@HiltAndroidApp
class CoinApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(CoinTimberTree())
    }
}