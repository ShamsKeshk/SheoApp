package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import com.udacity.shoestore.databinding.ItemShoesBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeViewModel

class ShoesListFragment : Fragment() {


    private lateinit var binding: FragmentShoesListBinding

    private val shoeViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = FragmentShoesListBinding.inflate(inflater,container,false)

        binding.fabAddShoe.setOnClickListener{
            it.findNavController().navigate(ShoesListFragmentDirections.actionShoesListFragmentToShoeDetailsFragment())
        }

        initShoeObserver()
        return binding.root
    }

    private fun initShoeObserver(){
        shoeViewModel.getShoeLiveData().observe(viewLifecycleOwner, Observer { it ->
            if (!shoeViewModel.isShouldUpdateView())
                return@Observer

            it?.forEach { shoe ->
                binding.llShoesList.addView(getViewForShoe(shoe))
            }
        })
    }


    private fun getViewForShoe(shoe: Shoe): View{
        val itemShoesBinding = ItemShoesBinding.inflate(LayoutInflater.from(requireContext()),null,false)
        itemShoesBinding.shoe = shoe
        itemShoesBinding.executePendingBindings()
        return itemShoesBinding.root
    }
}