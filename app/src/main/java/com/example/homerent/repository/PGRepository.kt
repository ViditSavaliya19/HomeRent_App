package com.example.homerent.repository

import com.example.homerent.domain.ApiClient.Companion.client
import com.example.homerent.domain.ApiInterface
import com.example.homerent.model.PGModel
import retrofit2.awaitResponse

class PGRepository {
    var apiInterface: ApiInterface = client.getApiClient()!!.create(ApiInterface::class.java)
    companion object{
        val repo = PGRepository()
    }


    suspend fun getPGListAPICall(): List<PGModel> {
        val response = apiInterface.getPGList().awaitResponse()
        if(response.isSuccessful && response.body() != null)
        {
            return response.body()!!
        }
        else
        {
            throw Exception("Error : ${response.code()}")
        }
    }


}