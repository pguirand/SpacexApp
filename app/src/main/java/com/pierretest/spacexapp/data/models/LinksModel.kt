package com.pierretest.spacexapp.data.models


import com.google.gson.annotations.SerializedName

data class LinksModel(
    @SerializedName("elon_twitter")
    val elonTwitter: String? = "",
    @SerializedName("flickr")
    val flickr: String? = "",
    @SerializedName("twitter")
    val twitter: String? = "",
    @SerializedName("website")
    val website: String? = ""
)