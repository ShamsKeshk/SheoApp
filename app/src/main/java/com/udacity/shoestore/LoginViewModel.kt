package com.udacity.shoestore

import android.util.Patterns
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    fun isEmailValid(email: String?): Boolean{
        return (!email.isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches())
    }

    fun isPasswordValid(password: String?): Boolean{
        return !password.isNullOrEmpty() && password.length > 6
    }
}