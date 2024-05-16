package com.example.homerent.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homerent.model.CityModel
import com.example.homerent.model.PGModel
import com.example.homerent.model.UserModel
import com.example.homerent.repository.PGRepository.Companion.repo
import kotlinx.coroutines.launch

class PgViewModel(val context: Context) : ViewModel() {

    var selectedPG : PGModel? = null

    private var _pgList = MutableLiveData<List<PGModel>>()
    private var _sortedPGList = MutableLiveData<List<PGModel>>()
    private var _cityList = MutableLiveData<List<CityModel>>()

    val pgList: MutableLiveData<List<PGModel>>
        get() = _pgList

    val sortedPGList:  MutableLiveData<List<PGModel>>
        get() = _sortedPGList

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
            launch {
                val map = HashMap<String,String>()
                Log.e("TAG", "$map", )
                getSortedPGList(map)
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

    public suspend fun getSortedPGList(sort:HashMap<String,String>) {
        try {
            _sortedPGList.value = repo.getSortedPGList(sort)
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


//    private suspend fun getSortedPGList(query:HashMap<String,String>) {
//        try {
//            _pgList.value = repo.getSortedPGListAPICall(query)
//        } catch (e: Exception) {
//            Log.e("TAG", "getPGList: ${e.message}")
//            Toast.makeText(context, "${e.message}", Toast.LENGTH_SHORT).show()
//        }
//
//    }


}