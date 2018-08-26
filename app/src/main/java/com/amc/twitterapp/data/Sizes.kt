package com.amc.twitterapp.data

import com.google.gson.annotations.SerializedName

data class Sizes(

	@field:SerializedName("small")
	val small: Small? = null,

	@field:SerializedName("large")
	val large: Large? = null,

	@field:SerializedName("thumb")
	val thumb: Thumb? = null,

	@field:SerializedName("medium")
	val medium: Medium? = null
)