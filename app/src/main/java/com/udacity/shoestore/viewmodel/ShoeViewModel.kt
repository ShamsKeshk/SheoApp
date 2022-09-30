package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel: ViewModel() {

    private val _shoeItemLiveData = MutableLiveData<MutableList<Shoe>?>(mutableListOf())
    private val _isHaveNewData = MutableLiveData<Boolean>(false)

    fun addShoe(shoe: Shoe){
        _isHaveNewData.value = true
        _shoeItemLiveData.value?.add(shoe)
        _shoeItemLiveData.value = _shoeItemLiveData.value
    }

    fun shoeAdded(){
        _isHaveNewData.value = false
    }

    fun isShouldUpdateView(): Boolean{
        return _isHaveNewData.value == true
    }

    fun getShoeLiveData(): LiveData<MutableList<Shoe>?> {
        return _shoeItemLiveData
    }

    fun isValidData(inputData: String?): Boolean{
        return !inputData.isNullOrEmpty()
    }

    fun isValidData(inputData: Double?): Boolean{
        inputData?.let {
            return it > 0
        }

        return false
    }


}