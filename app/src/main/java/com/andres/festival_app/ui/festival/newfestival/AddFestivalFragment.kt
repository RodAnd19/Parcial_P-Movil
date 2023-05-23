package com.andres.festival_app.ui.festival.newfestival

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.andres.festival_app.databinding.FragmentAddFestivalBinding
import com.andres.festival_app.ui.festival.viewmodel.FestivalViewModel

class AddFestivalFragment : Fragment() {

    private val festivalViewModel : FestivalViewModel by activityViewModels {
        FestivalViewModel.Factory
    }

    private lateinit var binding : FragmentAddFestivalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddFestivalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()

    }

    private fun setViewModel() {
        binding.viewmodel = festivalViewModel
    }

    private fun observeStatus() {
        festivalViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(FestivalViewModel.WRONG_INFORMATION) -> {
                    Log.d(APP_TAG, status)
                    festivalViewModel.clearStatus()
                }
                status.equals(FestivalViewModel.FESTIVAL_CREATED) -> {
                    Log.d(APP_TAG, status)
                    Log.d(APP_TAG, festivalViewModel.getFestivals().toString())

                    festivalViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

    companion object {
        const val APP_TAG = "APP_TAG"
    }

}