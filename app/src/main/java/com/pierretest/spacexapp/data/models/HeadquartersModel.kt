package com.pierretest.spacexapp.data.models


import com.google.gson.annotations.SerializedName

data class HeadquartersModel(
    @SerializedName("address")
    val address: String? = "",
    @SerializedName("city")
    val city: String? = "",
    @SerializedName("state")
    val state: String? = ""
)