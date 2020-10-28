package com.project.segunfrancis.cleancoin.ui.coinlist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.project.segunfrancis.cleancoin.databinding.FragmentCoinListBinding
import com.project.segunfrancis.cleancoin.utils.Result.Success
import com.project.segunfrancis.cleancoin.utils.Result.Error
import com.project.segunfrancis.cleancoin.utils.Result.Loading

class CoinListFragment : Fragment() {

    private lateinit var binding: FragmentCoinListBinding
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

        viewModel.coinResponse.observe(viewLifecycleOwner, {result ->
            when(result) {
                is Loading -> {
                    Snackbar.make(view, "Loading", Snackbar.LENGTH_LONG).show()
                }
                is Error -> {
                    Snackbar.make(view, result.error.localizedMessage!!, Snackbar.LENGTH_LONG).show()
                    Log.e("CoinListFragment", result.error.localizedMessage!!)
                }
                is Success -> {
                    //Snackbar.make(view, result.data!!.status, Snackbar.LENGTH_LONG).show()
                }
            }
        })
    }
}