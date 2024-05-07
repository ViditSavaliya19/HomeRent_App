package com.example.homerent.model

import com.google.gson.annotations.SerializedName

data class CityModel(

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)
