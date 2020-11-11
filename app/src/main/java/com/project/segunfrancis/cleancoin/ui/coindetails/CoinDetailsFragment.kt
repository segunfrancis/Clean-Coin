package com.project.segunfrancis.cleancoin.ui.coindetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import coil.ImageLoader
import com.project.segunfrancis.cleancoin.databinding.FragmentCoinDetailsBinding
import com.project.segunfrancis.cleancoin.ui.coindetails.adapter.CoinPagerAdapter
import com.project.segunfrancis.cleancoin.ui.coinlist.CoinListViewModel
import com.project.segunfrancis.cleancoin.utils.Result
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CoinDetailsFragment : Fragment() {

    private val args: CoinDetailsFragmentArgs by navArgs()
    private val viewModel: CoinListViewModel by viewModels()
    @Inject lateinit var imageLoader: ImageLoader
    private lateinit var binding: FragmentCoinDetailsBinding
    private lateinit var pagerAdapter: CoinPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCoinDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pagerAdapter = CoinPagerAdapter(imageLoader)
        viewModel.coinResponse.observe(viewLifecycleOwner) { result ->
            if (result is Result.Success) {
                pagerAdapter.submitList(result.data)
                binding.viewPager.apply {
                    adapter = pagerAdapter
                    setCurrentItem(args.position, false)
                }
            }
        }
    }
}