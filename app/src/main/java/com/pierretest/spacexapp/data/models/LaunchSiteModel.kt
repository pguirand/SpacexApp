package com.pierretest.spacexapp.data.models


import com.google.gson.annotations.SerializedName

data class LaunchSiteModel(
    @SerializedName("site_id")
    val siteId: String? = "",
    @SerializedName("site_name")
    val siteName: String? = "",
    @SerializedName("site_name_long")
    val siteNameLong: String? = ""
)