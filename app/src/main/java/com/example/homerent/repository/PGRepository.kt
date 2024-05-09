package com.example.homerent.repository

import android.util.Log
import com.example.homerent.domain.ApiClient.Companion.client
import com.example.homerent.domain.ApiInterface
import com.example.homerent.model.CityModel
import com.example.homerent.model.PGModel
import com.example.homerent.model.UserModel
import retrofit2.awaitResponse

class PGRepository {
    var apiInterface: ApiInterface = client.getApiClient()!!.create(ApiInterface::class.java)

    companion object {
        val repo = PGRepository()
    }


    suspend fun getPGListAPICall(): List<PGModel> {
        val response = apiInterface.getPGList().awaitResponse()
        if (response.isSuccessful && response.body() != null) {
            Log.e("TAG", "getPGListAPICall: ${response.body()}")
            return response.body()!!
        }

        throw Exception("Error : ${response.code()}")
    }

    suspend fun getCityListAPICall(): List<CityModel> {
        val response = apiInterface.getCityList().awaitResponse()
        if (response.isSuccessful && response.body() != null) {
            Log.e("TAG", "getCityList: ${response.body()}")
            return response.body()!!
        }

        throw Exception("Error : ${response.code()}")
    }

    suspend fun postUserDetailsAPICall(map: HashMap<String, String>): Boolean {
        val response = apiInterface.postUserDetails(map).awaitResponse()
        Log.e("TAG", "postUserDetails Body : ${response.body()}")
        if (response.isSuccessful) {
            Log.e("TAG", "postUserDetails: ${response.body()}")
            return true
        } else if (response.code() != 200) {
            return false
        }

        throw Exception("Error : ${response.code()}")
    }

    suspend fun getUserInfoAPICall(uid:String): List<UserModel> {
        val response = apiInterface.getUserDetails(uid).awaitResponse()
        if (response.isSuccessful && response.body() != null) {
            Log.e("TAG", "getUserInfo: ${response.body()}")
            return response.body()!!
        }

        throw Exception("Error : ${response.code()}")
    }



}