package com.project.segunfrancis.cleancoin.ui.coindetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import coil.ImageLoader
import com.project.segunfrancis.cleancoin.databinding.FragmentCoinDetailsBinding
import com.project.segunfrancis.cleancoin.ui.coindetails.adapter.CoinPagerAdapter
import com.project.segunfrancis.cleancoin.ui.coinlist.CoinListViewModel
import com.project.segunfrancis.cleancoin.utils.AppConstants.PAGER_SAVED_STATE_KEY
import com.project.segunfrancis.cleancoin.utils.Result
import com.project.segunfrancis.cleancoin.utils.makeGone
import com.project.segunfrancis.cleancoin.utils.makeVisible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_coin_details.*
import javax.inject.Inject

@AndroidEntryPoint
class CoinDetailsFragment : Fragment() {

    private val args: CoinDetailsFragmentArgs by navArgs()
    private val viewModel: CoinListViewModel by viewModels()
    @Inject
    lateinit var imageLoader: ImageLoader
    private lateinit var binding: FragmentCoinDetailsBinding
    private lateinit var pagerAdapter: CoinPagerAdapter
    private var itemSize: Int = 0

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
                itemSize += result.data!!.size - 1
                binding.viewPager.apply {
                    adapter = pagerAdapter
                    setCurrentItem(args.position, false)
                }
            }
        }

        binding.previousCoin.setOnClickListener {
            viewPager.setCurrentItem(viewPager.currentItem - 1, true)
        }

        binding.nextCoin.setOnClickListener {
            viewPager.setCurrentItem(viewPager.currentItem + 1, true)
        }

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                when (position) {
                    0 -> { // First item
                        binding.previousCoin.makeGone()
                    }
                    itemSize -> { // Last item
                        binding.nextCoin.makeGone()
                    }
                    else -> {
                        binding.previousCoin.makeVisible()
                        binding.nextCoin.makeVisible()
                    }
                }
            }
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(PAGER_SAVED_STATE_KEY, binding.viewPager.currentItem)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (savedInstanceState != null) {
            binding.viewPager.setCurrentItem(
                savedInstanceState.getInt(PAGER_SAVED_STATE_KEY),
                false
            )
        }
    }
}