package com.pierretest.spacexapp.data.models


import com.google.gson.annotations.SerializedName

data class TelemetryModel(
    @SerializedName("flight_club")
    val flightClub: Any? = Any()
)