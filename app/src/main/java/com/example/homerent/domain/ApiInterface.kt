package com.example.homerent.domain

import com.example.homerent.domain.Constant.Companion.CITYLIST
import com.example.homerent.domain.Constant.Companion.PGLIST
import com.example.homerent.domain.Constant.Companion.USERDETAILS
import com.example.homerent.domain.Constant.Companion.USERINFO
import com.example.homerent.model.CityModel
import com.example.homerent.model.PGModel
import com.example.homerent.model.UserModel
import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiInterface {

    @GET(PGLIST)
    fun getPGList(): Call<List<PGModel>>

    @GET(PGLIST)
    fun getSortedPGList(@QueryMap query:HashMap<String,String>): Call<List<PGModel>>

    @GET(CITYLIST)
    fun getCityList(): Call<List<CityModel>>

    @GET(USERINFO)
    fun getUserDetails(@Query("fireUid") fireUid: String): Call<List<UserModel>>

    @FormUrlEncoded
    @POST(USERDETAILS)
    fun postUserDetails(@FieldMap params: HashMap<String, String>): Call<Void>


}