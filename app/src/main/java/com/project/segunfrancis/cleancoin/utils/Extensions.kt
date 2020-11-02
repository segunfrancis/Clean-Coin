package com.project.segunfrancis.cleancoin.utils

import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import coil.ImageLoader
import coil.request.ImageRequest
import com.project.segunfrancis.cleancoin.R

/**
 * Created by SegunFrancis
 */

fun <T> MutableLiveData<T>.asLiveData() = this as LiveData<T>

fun ImageView.loadImage(url: String, imageLoader: ImageLoader) {
    val request = ImageRequest.Builder(this.context)
        .data(url)
        .target(this)
        .placeholder(R.drawable.loading_animation)
        .error(R.drawable.ic_baseline_warning)
        .build()
    imageLoader.enqueue(request)
}