package com.project.segunfrancis.cleancoin.ui.coinlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import com.project.segunfrancis.cleancoin.R
import com.project.segunfrancis.cleancoin.databinding.ItemCoinsBinding
import com.project.segunfrancis.cleancoin.ui.coinlist.model.Coin
import com.project.segunfrancis.cleancoin.utils.loadImage

/**
 * Created by SegunFrancis
 */

class CoinRecyclerAdapter(
    private val imageLoader: ImageLoader,
    private val click: (item: Coin) -> Unit
) :
    ListAdapter<Coin, CoinRecyclerAdapter.CoinViewHolder>(CoinDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_coins, parent, false)
        return CoinViewHolder(ItemCoinsBinding.bind(view))
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CoinViewHolder(private val binding: ItemCoinsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Coin) = with(binding) {
            coinImageView.loadImage(item.iconUrl, imageLoader)
            coinName.text = item.name
            root.setOnClickListener {
                click(item)
            }
        }
    }
}

class CoinDiffUtil : DiffUtil.ItemCallback<Coin>() {

    override fun areItemsTheSame(oldItem: Coin, newItem: Coin): Boolean {
        return oldItem.id == newItem.id
    }


    override fun areContentsTheSame(oldItem: Coin, newItem: Coin): Boolean {
        return oldItem == newItem
    }
}