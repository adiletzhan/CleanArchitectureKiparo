package com.example.cleanarchitecture.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.models.UserName
import com.example.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val saveUserNameUseCase: SaveUserNameUseCase,
    private val getUserNameUseCase: GetUserNameUseCase
): ViewModel() {

    private val resultLiveMutable =  MutableLiveData<String>()
    val resultLive: LiveData<String> = resultLiveMutable

    init {
        Log.e("AAA", "VM Created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM Cleared")
        super.onCleared()
    }

    fun save(text: String){
        val param = SaveUserNameParam(name = text)
        val resultData = saveUserNameUseCase.execute(param = param)
        resultLiveMutable.value = "Save data result = $resultData"
    }

    fun load() {
        val userName: UserName = getUserNameUseCase.execute()
        resultLiveMutable.value = "${userName.firstName} ${userName.lastName}"
    }
}