package com.example.homerent.domain

import com.example.homerent.domain.Constant.Companion.CITYLIST
import com.example.homerent.domain.Constant.Companion.PGLIST
import com.example.homerent.domain.Constant.Companion.USERDETAILS
import com.example.homerent.model.CityModel
import com.example.homerent.model.PGModel
import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @GET(PGLIST)
    fun getPGList(): Call<List<PGModel>>

    @GET(CITYLIST)
    fun getCityList(): Call<List<CityModel>>

    @FormUrlEncoded
    @POST(USERDETAILS)
    fun postUserDetails(@FieldMap params: HashMap<String, String>): Call<Void>


}