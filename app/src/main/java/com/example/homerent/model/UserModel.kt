package com.example.homerent.model

import com.google.gson.annotations.SerializedName

data class UserModel(

	@field:SerializedName("UserModel")
	val userModel: List<UserModelItem?>? = null
)

data class UserModelItem(

	@field:SerializedName("area")
	val area: String? = null,

	@field:SerializedName("profession")
	val profession: String? = null,

	@field:SerializedName("uid")
	val uid: String? = null,

	@field:SerializedName("fireuid")
	val fireuid: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("postal code")
	val postalCode: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("mobile")
	val mobile: String? = null,

	@field:SerializedName("state")
	val state: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
