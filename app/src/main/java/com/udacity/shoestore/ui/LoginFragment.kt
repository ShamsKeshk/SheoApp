package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.viewmodel.LoginViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding


/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {


    private lateinit var binding: FragmentLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View{
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        binding.btnLogin.setOnClickListener {
            if (isValidateCredentials()) {
                performLogin(it)
            }
        }

        binding.btnSignup.setOnClickListener {
            if (isValidateCredentials()) {
                performLogin(it)
            }
        }

        return binding.root
    }

    private fun isValidateCredentials(): Boolean{
        clearErrorState()

        var isDataValid = true
        if (!loginViewModel.isEmailValid(getEmail())) {
            binding.tilEmail.error = getString(R.string.login_email_error_message)
            binding.tilEmail.isErrorEnabled = true
            isDataValid = false
        }

        if (!loginViewModel.isPasswordValid(getPassword())){
            binding.tilPassword.error = getString(R.string.login_password_error_message)
            binding.tilPassword.isErrorEnabled = true
            isDataValid = false
        }

        return isDataValid
    }

    private fun clearErrorState(){
        binding.tilEmail.error = null
        binding.tilEmail.isErrorEnabled = false

        binding.tilPassword.error = null
        binding.tilPassword.isErrorEnabled = false
    }

    private fun performLogin(view: View){
        view.findNavController().navigate(LoginFragmentDirections.actionLoginFragment2ToWelcomeScreenFragment())
    }

    private fun getEmail(): String {
        return binding.etEmail.text.toString()
    }

    private fun getPassword(): String {
        return binding.etPassword.text.toString()
    }
}