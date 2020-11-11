package com.project.segunfrancis.cleancoin.ui.coindetails

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import coil.ImageLoader
import com.project.segunfrancis.cleancoin.databinding.FragmentCoinDetailsBinding
import com.project.segunfrancis.cleancoin.utils.loadImage
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CoinDetailsFragment : Fragment() {

    private lateinit var binding: FragmentCoinDetailsBinding
    private val args: CoinDetailsFragmentArgs by navArgs()
    @Inject lateinit var imageLoader: ImageLoader

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCoinDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coin = args.coin
        binding.nameTextView.text = coin.name
        binding.priceTextView.text = "$".plus(coin.price)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            binding.descriptionTextView.text = Html.fromHtml(coin.description ?: "", Html.FROM_HTML_MODE_COMPACT)
        } else {
            @Suppress("DEPRECATION")
            binding.descriptionTextView.text = Html.fromHtml(coin.description ?: "")
        }
        binding.coinImageView.loadImage(coin.iconUrl, imageLoader)
    }
}