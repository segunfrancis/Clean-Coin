package com.project.segunfrancis.cleancoin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.segunfrancis.cleancoin.databinding.FragmentCoinListBinding

class CoinListFragment : Fragment() {

    private lateinit var binding: FragmentCoinListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCoinListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}