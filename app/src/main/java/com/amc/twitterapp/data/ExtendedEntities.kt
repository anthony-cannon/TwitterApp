package com.amc.twitterapp.data

import com.google.gson.annotations.SerializedName

data class ExtendedEntities(

	@field:SerializedName("media")
	val media: List<MediaItem?>? = null
)