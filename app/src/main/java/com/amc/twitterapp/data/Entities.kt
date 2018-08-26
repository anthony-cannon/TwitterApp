package com.amc.twitterapp.data

import com.google.gson.annotations.SerializedName

data class Entities(

	@field:SerializedName("description")
	val description: Description? = null,

	@field:SerializedName("url")
	val url: Url? = null,

	@field:SerializedName("urls")
	val urls: List<UrlsItem?>? = null,

	@field:SerializedName("hashtags")
	val hashtags: List<Any?>? = null,

	@field:SerializedName("media")
	val media: List<MediaItem?>? = null,

	@field:SerializedName("user_mentions")
	val userMentions: List<Any?>? = null,

	@field:SerializedName("symbols")
	val symbols: List<Any?>? = null
)