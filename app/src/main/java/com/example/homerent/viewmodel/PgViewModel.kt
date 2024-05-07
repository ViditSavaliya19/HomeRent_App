package com.example.homerent.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homerent.model.CityModel
import com.example.homerent.model.PGModel
import com.example.homerent.repository.PGRepository.Companion.repo
import kotlinx.coroutines.launch

class PgViewModel(val context: Context) : ViewModel() {
    private var _pgList = MutableLiveData<List<PGModel>>()
    private var _cityList = MutableLiveData<List<CityModel>>()
    val pgList: MutableLiveData<List<PGModel>>
        get() = _pgList

    val cityList: MutableLiveData<List<CityModel>>
        get() = _cityList

    init {
        viewModelScope.launch {
            launch {
                getCityList()
            }
            launch {
                getPGList()
            }
        }
    }

    private suspend fun getPGList() {
        try {
            _pgList.value = repo.getPGListAPICall()
        } catch (e: Exception) {
            Log.e("TAG", "getPGList: ${e.message}")
            Toast.makeText(context, "${e.message}", Toast.LENGTH_SHORT).show()
        }

    }

    private suspend fun getCityList() {
        try {
            _cityList.value = repo.getCityListAPICall()
        } catch (e: Exception) {
            Log.e("TAG", "getCityList: ${e.message}")
            Toast.makeText(context, "${e.message}", Toast.LENGTH_SHORT).show()
        }

    }

    suspend fun postUserDetails(map:HashMap<String,String>): Boolean {
        try {
            return repo.postUserDetailsAPICall(map)
        } catch (e: Exception) {
            Log.e("TAG", "postUserDetails: ${e.message}")
            Toast.makeText(context, "${e.message}", Toast.LENGTH_SHORT).show()
        }
        return  false
    }

}