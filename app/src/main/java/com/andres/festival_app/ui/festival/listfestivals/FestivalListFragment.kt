package com.andres.festival_app.ui.festival.listfestivals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.andres.festival_app.R
import com.andres.festival_app.data.model.FestivalModel
import com.andres.festival_app.databinding.FragmentFestivalListBinding
import com.andres.festival_app.ui.festival.listfestivals.recyclerview.FestivalRecyclerViewAdapter
import com.andres.festival_app.ui.festival.viewmodel.FestivalViewModel


class FestivalListFragment : Fragment() {

    private val festivalViewModel : FestivalViewModel by activityViewModels {
        FestivalViewModel.Factory
    }

    private lateinit var binding : FragmentFestivalListBinding

    private lateinit var adapter: FestivalRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFestivalListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.addFestivalButton.setOnClickListener {
            festivalViewModel.clearData()
            it.findNavController().navigate(R.id.action_festivalListFragment_to_addFestivalFragment)
        }
    }

    private fun showSelectedItem(festival : FestivalModel) {
        festivalViewModel.setSelectedFestival(festival)
        findNavController().navigate(R.id.action_festivalListFragment_to_festivalItemFragment)
    }

    private fun displayFestival() {
        adapter.setData(festivalViewModel.getFestivals())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = FestivalRecyclerViewAdapter { selectedFestival ->
            showSelectedItem(selectedFestival)
        }

        binding.recyclerView.adapter = adapter
        displayFestival()
    }

}