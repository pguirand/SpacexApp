package com.pierretest.spacexapp.data.models


import com.google.gson.annotations.SerializedName

data class MissionModel(
    @SerializedName("flight")
    val flight: Int? = 0,
    @SerializedName("name")
    val name: String? = ""
)