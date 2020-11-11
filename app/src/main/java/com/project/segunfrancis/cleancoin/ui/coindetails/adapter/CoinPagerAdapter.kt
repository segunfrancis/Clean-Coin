package com.project.segunfrancis.cleancoin.ui.coindetails.adapter

import android.text.Html
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import coil.ImageLoader
import com.project.segunfrancis.cleancoin.R
import com.project.segunfrancis.cleancoin.databinding.PagerItemCoinsBinding
import com.project.segunfrancis.cleancoin.ui.coinlist.adapter.CoinDiffUtil
import com.project.segunfrancis.cleancoin.ui.coinlist.model.Coin
import com.project.segunfrancis.cleancoin.utils.loadImage

/**
 * Created by SegunFrancis
 */

class CoinPagerAdapter(private val imageLoader: ImageLoader) :
    ListAdapter<Coin, CoinPagerAdapter.CoinPagerViewHolder>(CoinDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinPagerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pager_item_coins, parent, false)
        return CoinPagerViewHolder(
            PagerItemCoinsBinding.bind(view)
        )
    }

    override fun onBindViewHolder(holder: CoinPagerViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class CoinPagerViewHolder(private val binding: PagerItemCoinsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(coin: Coin?) = with(binding) {
            coinImageView.loadImage(coin!!.iconUrl, imageLoader)
            nameTextView.text = coin.name
            priceTextView.text = "$".plus(coin.price)
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                descriptionTextView.text =
                    Html.fromHtml(coin.description ?: "", Html.FROM_HTML_MODE_COMPACT)
            } else {
                @Suppress("DEPRECATION")
                descriptionTextView.text = Html.fromHtml(coin.description ?: "")
            }
        }
    }
}