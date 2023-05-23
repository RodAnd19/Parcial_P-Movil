package com.andres.festival_app.ui.festival

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andres.festival_app.R
import com.andres.festival_app.databinding.FragmentFestivalItemBinding
import com.andres.festival_app.databinding.FragmentFestivalListBinding

class FestivalItemFragment : Fragment() {

    private lateinit var binding : FragmentFestivalItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFestivalItemBinding.inflate(inflater, container, false)
        return binding.root
    }

}