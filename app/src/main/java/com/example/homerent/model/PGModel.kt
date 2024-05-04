package com.example.homerent.model

import com.google.gson.annotations.SerializedName

data class PGModel(

	@field:SerializedName("bed")
	val bed: String? = null,

	@field:SerializedName("area")
	val area: String? = null,

	@field:SerializedName("images")
	val images: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("postalcode")
	val postalcode: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("deposit")
	val deposit: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("state")
	val state: String? = null,

	@field:SerializedName("rent")
	val rent: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("category")
	val category: String? = null
)
