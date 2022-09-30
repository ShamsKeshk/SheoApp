package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeScreenBinding

class WelcomeScreenFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentWelcomeScreenBinding.inflate(inflater,container,false)

        binding.btnCheckInstructions.setOnClickListener {
            it.findNavController().navigate(WelcomeScreenFragmentDirections.actionWelcomeScreenFragmentToInstructionsFragment())
        }

        return binding.root
    }
}