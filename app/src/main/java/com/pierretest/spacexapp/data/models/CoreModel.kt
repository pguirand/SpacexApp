package com.pierretest.spacexapp.data.models


import com.google.gson.annotations.SerializedName

data class CoreModel(
    @SerializedName("block")
    val block: Int? = 0,
    @SerializedName("core_serial")
    val coreSerial: String? = "",
    @SerializedName("flight")
    val flight: Int? = 0,
    @SerializedName("gridfins")
    val gridfins: Boolean? = false,
    @SerializedName("land_success")
    val landSuccess: Boolean? = false,
    @SerializedName("landing_intent")
    val landingIntent: Boolean? = false,
    @SerializedName("landing_type")
    val landingType: String? = "",
    @SerializedName("landing_vehicle")
    val landingVehicle: String? = "",
    @SerializedName("legs")
    val legs: Boolean? = false,
    @SerializedName("reused")
    val reused: Boolean? = false
)