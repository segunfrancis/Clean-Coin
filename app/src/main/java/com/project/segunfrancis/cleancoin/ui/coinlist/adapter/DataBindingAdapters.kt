package com.project.segunfrancis.cleancoin.ui.coinlist.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.request.ImageRequest
import com.project.segunfrancis.cleancoin.R
import com.project.segunfrancis.cleancoin.ui.coinlist.model.Coin
import javax.inject.Inject

/**
 * Created by SegunFrancis
 */

/*
@Inject
lateinit var imageLoader: ImageLoader

@BindingAdapter("showList")
fun displayRecyclerViewList(recyclerView: RecyclerView, items: List<Coin>?) {
    var adapter = (recyclerView.adapter as? CoinRecyclerAdapter)
    if (adapter == null) {
        adapter = CoinRecyclerAdapter(imageLoader) { }
    }
    adapter.submitList(items.orEmpty())
}

@BindingAdapter("loadImage")
fun loadImage(image: ImageView, url: String) {
    val request = ImageRequest.Builder(image.context)
        .data(url)
        .target(image)
        .placeholder(R.drawable.loading_animation)
        .error(R.drawable.ic_baseline_warning)
        .build()
    imageLoader.enqueue(request)
}
*/
