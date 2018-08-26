package com.amc.twitterapp.data

import com.google.gson.annotations.SerializedName

data class Description(

	@field:SerializedName("urls")
	val urls: List<Any?>? = null
)