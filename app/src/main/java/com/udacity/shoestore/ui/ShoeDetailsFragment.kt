package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.viewmodel.ShoeViewModel
import kotlinx.android.synthetic.main.fragment_shoe_details.*

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailsFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailsBinding
    private val shoeViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding =  FragmentShoeDetailsBinding.inflate(inflater, container, false)

        binding.vm = shoeViewModel
        binding.lifecycleOwner = this

        binding.btnSaveShoeOrder.setOnClickListener{

            shoeViewModel.isShouldValidateFields.value = true

            if (shoeViewModel.isNewShoeDataValid()){
                shoeViewModel.newAddedShoe.apply {
                    shoeViewModel.addShoe(shoe = this)
                    it.findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoesListFragment())
                }
            }
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        shoeViewModel.clearAddingShoeSession()
    }
}