package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe
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
        binding.lifecycleOwner = this

        binding.btnSaveShoeOrder.setOnClickListener{

            if (isValidateData()){
                getShoeToAdd().apply {
                    shoeViewModel.addShoe(shoe = this)
                    it.findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoesListFragment())
                }
            }
        }

        return binding.root
    }

    private fun getShoeToAdd(): Shoe{
        return Shoe().apply {
            name = getShoeName()
            size = getShoeSize().toDouble()
            company = getShoeCompany()
            description = getShoeDescription()
        }
    }

    private fun isValidateData(): Boolean{
        clearErrorState()
        var isDataValid = true

        if (!shoeViewModel.isValidData(getShoeName())){
            binding.tilName.isErrorEnabled = true
            binding.tilName.error = getString(R.string.shoe_name_validation_error)

            isDataValid = false
        }

        if (!shoeViewModel.isValidData(getShoeCompany())){
            binding.tilCompanyName.isErrorEnabled = true
            binding.tilCompanyName.error = getString(R.string.shoe_company_validation_error)
            isDataValid = false
        }

        if (!shoeViewModel.isValidData(getShoeSize().toDoubleOrNull())){
            binding.tilShoeSize.isErrorEnabled = true
            binding.tilShoeSize.error = getString(R.string.shoe_size_validation_error)

            isDataValid = false
        }

        if (!shoeViewModel.isValidData(getShoeDescription())){
            binding.tilShoeDescription.isErrorEnabled = true
            binding.tilShoeDescription.error = getString(R.string.shoe_description_validation_error)

            isDataValid = false
        }

        return isDataValid
    }

    private fun clearErrorState(){
        binding.tilName.isErrorEnabled = false
        binding.tilCompanyName.isErrorEnabled = false
        binding.tilShoeSize.isErrorEnabled = false
        binding.tilShoeDescription.isErrorEnabled = false
    }

    private fun getShoeName(): String{
        return binding.etName.text.toString()
    }

    private fun getShoeCompany(): String{
        return binding.etCompanyName.text.toString()
    }

    private fun getShoeSize(): String{
        return binding.etShoeSize.text.toString()
    }

    private fun getShoeDescription(): String{
        return binding.etShoeDescription.text.toString()
    }



}