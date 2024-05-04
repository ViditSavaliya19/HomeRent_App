package com.example.homerent.domain

import com.example.homerent.domain.Constant.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient {

    companion object {
        var client = ApiClient()
    }

    var retrofit: Retrofit? = null

    fun getApiClient(): Retrofit? {

        if (retrofit == null) {
            retrofit =
                Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        return retrofit
    }
}