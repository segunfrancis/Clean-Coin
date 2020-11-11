package com.project.segunfrancis.cleancoin.ui.coinlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import coil.ImageLoader
import com.project.segunfrancis.cleancoin.R
import com.project.segunfrancis.cleancoin.databinding.FragmentCoinListBinding
import com.project.segunfrancis.cleancoin.ui.coinlist.adapter.CoinRecyclerAdapter
import com.project.segunfrancis.cleancoin.utils.Result.Success
import com.project.segunfrancis.cleancoin.utils.Result.Error
import com.project.segunfrancis.cleancoin.utils.Result.Loading
import com.project.segunfrancis.cleancoin.utils.makeGone
import com.project.segunfrancis.cleancoin.utils.makeVisible
import com.project.segunfrancis.cleancoin.utils.showSnack
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class CoinListFragment : Fragment() {

    private lateinit var binding: FragmentCoinListBinding

    @Inject
    lateinit var imageLoader: ImageLoader
    private val viewModel: CoinListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCoinListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coinRecyclerAdapter = CoinRecyclerAdapter(imageLoader) {
            val action = CoinListFragmentDirections.actionCoinListFragmentToCoinDetailsFragment(it)
            findNavController().navigate(action)
        }
        binding.coinRecyclerView.apply {
            layoutManager =
                GridLayoutManager(requireContext(), resources.getInteger(R.integer.span_count))
            adapter = coinRecyclerAdapter
        }
        binding.retryButton.setOnClickListener {
            viewModel.getCoinsRemote()
        }

        viewModel.coinResponse.observe(viewLifecycleOwner, { result ->
            when (result) {
                is Loading -> {
                    binding.loadingIndicator.makeVisible()
                    binding.errorGroup.makeGone()
                }
                is Error -> {
                    binding.root.showSnack(result.formattedError)
                    binding.loadingIndicator.makeGone()
                    binding.errorGroup.makeVisible()
                    Timber.e(result.error, result.error.localizedMessage)
                }
                is Success -> {
                    val coins = result.data
                    coinRecyclerAdapter.submitList(coins)
                    binding.loadingIndicator.makeGone()
                    if (coins.isNullOrEmpty()) {
                        viewModel.getCoinsRemote()
                    }
                    binding.errorGroup.makeGone()
                }
            }
        })
    }
}