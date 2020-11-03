package com.project.segunfrancis.cleancoin.ui.coinlist.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by SegunFrancis
 */

@Parcelize
data class Coin(
    val id: Int,
    val symbol: String,
    val name: String,
    val description: String?,
    val iconUrl: String,
    val price: String
): Parcelable