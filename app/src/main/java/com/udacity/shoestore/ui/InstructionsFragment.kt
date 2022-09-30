package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentInstructionsBinding.inflate(inflater,container,false)


        binding.btnAddShoe.setOnClickListener(View.OnClickListener {
            it.findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragmentToShoesListFragment())
        })

        return binding.root
    }
}