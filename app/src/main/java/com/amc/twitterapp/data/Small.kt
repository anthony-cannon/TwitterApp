package com.amc.twitterapp.data

import com.google.gson.annotations.SerializedName

data class Small(

	@field:SerializedName("w")
	val W: Int? = null,

	@field:SerializedName("h")
	val H: Int? = null,

	@field:SerializedName("resize")
	val resize: String? = null
)