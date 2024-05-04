package com.example.homerent.domain

import com.example.homerent.domain.Constant.Companion.PGLIST
import com.example.homerent.model.PGModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET(PGLIST)
    suspend  fun getPGList(): Call<List<PGModel>>


}