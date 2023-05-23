package com.andres.festival_app.ui.festival

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.andres.festival_app.R
import com.andres.festival_app.data.model.FestivalModel
import com.andres.festival_app.databinding.FragmentFestivalItemBinding
import com.andres.festival_app.databinding.FragmentFestivalListBinding
import com.andres.festival_app.ui.festival.viewmodel.FestivalViewModel

class FestivalItemFragment : Fragment() {

    private lateinit var binding : FragmentFestivalItemBinding

    private val festivalViewModel : FestivalViewModel by activityViewModels {
        FestivalViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFestivalItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()

    }

    private fun setViewModel() {
        binding.viewmodel = festivalViewModel
    }

}