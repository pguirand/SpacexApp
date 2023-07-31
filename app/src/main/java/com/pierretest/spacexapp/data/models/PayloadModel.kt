package com.pierretest.spacexapp.data.models


import com.google.gson.annotations.SerializedName

data class PayloadModel(
    @SerializedName("customers")
    val customers: List<String?>? = listOf(),
    @SerializedName("manufacturer")
    val manufacturer: String? = "",
    @SerializedName("nationality")
    val nationality: String? = "",
    @SerializedName("norad_id")
    val noradId: List<Int?>? = listOf(),
    @SerializedName("orbit")
    val orbit: String? = "",
    @SerializedName("orbit_params")
    val orbitParams: OrbitParamsModel? = OrbitParamsModel(),
    @SerializedName("payload_id")
    val payloadId: String? = "",
    @SerializedName("payload_mass_kg")
    val payloadMassKg: Double? = 0.0,
    @SerializedName("payload_mass_lbs")
    val payloadMassLbs: Double? = 0.0,
    @SerializedName("payload_type")
    val payloadType: String? = "",
    @SerializedName("reused")
    val reused: Boolean? = false
)