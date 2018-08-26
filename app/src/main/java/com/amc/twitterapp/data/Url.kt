package com.amc.twitterapp.data

import com.google.gson.annotations.SerializedName

data class Url(

	@field:SerializedName("urls")
	val urls: List<UrlsItem?>? = null
)