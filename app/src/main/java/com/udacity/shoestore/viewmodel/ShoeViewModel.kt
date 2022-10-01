package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe


class ShoeViewModel: ViewModel() {

    var isShouldValidateFields: MutableLiveData<Boolean> = MutableLiveData(false)

    private val _shoeItemLiveData = MutableLiveData<MutableList<Shoe>?>(mutableListOf())

    var newAddedShoe = Shoe()

    fun addShoe(shoe: Shoe){
        _shoeItemLiveData.value?.add(shoe)
        _shoeItemLiveData.value = _shoeItemLiveData.value
    }

    fun clearAddingShoeSession(){
        isShouldValidateFields.value = false
        newAddedShoe = Shoe()
    }

    fun getShoeLiveData(): LiveData<MutableList<Shoe>?> {
        return _shoeItemLiveData
    }

    fun isValidData(inputData: String?): Boolean{
        return !inputData.isNullOrEmpty()
    }

    fun isNewShoeDataValid(): Boolean{
        return newAddedShoe.let {
            isValidData(it.name) &&
                    isValidData(it.company) &&
                    isValidData(it.size) &&
                    isValidData(it.description)
        }
    }

    fun isValidData(inputData: Double?): Boolean{
        inputData?.let {
            return it > 0
        }

        return false
    }


}