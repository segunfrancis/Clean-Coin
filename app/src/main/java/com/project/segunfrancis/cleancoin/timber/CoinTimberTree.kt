package com.project.segunfrancis.cleancoin.timber

import android.util.Log
import android.util.Log.ERROR
import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber

/**
 * Created by SegunFrancis
 */

class CoinTimberTree : Timber.Tree() {
    /**
     * Write a log message to its destination. Called for all level-specific methods by default.
     *
     * @param priority Log level. See [Log] for constants.
     * @param tag Explicit or inferred tag. May be `null`.
     * @param message Formatted log message. May be `null`, but then `t` will not be.
     * @param t Accompanying exceptions. May be `null`, but then `message` will not be.
     */
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == ERROR) {
            FirebaseCrashlytics.getInstance()
                .recordException(t!!)
        }
    }
}