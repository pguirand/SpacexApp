package com.pierretest.spacexapp.data.models


import com.google.gson.annotations.SerializedName

data class OrbitParamsModel(
    @SerializedName("apoapsis_km")
    val apoapsisKm: Double? = 0.0,
    @SerializedName("arg_of_pericenter")
    val argOfPericenter: Double? = 0.0,
    @SerializedName("eccentricity")
    val eccentricity: Double? = 0.0,
    @SerializedName("epoch")
    val epoch: String? = "",
    @SerializedName("inclination_deg")
    val inclinationDeg: Double? = 0.0,
    @SerializedName("lifespan_years")
    val lifespanYears: Double? = 0.0,
    @SerializedName("longitude")
    val longitude: Double? = 0.0,
    @SerializedName("mean_anomaly")
    val meanAnomaly: Double? = 0.0,
    @SerializedName("mean_motion")
    val meanMotion: Double? = 0.0,
    @SerializedName("periapsis_km")
    val periapsisKm: Double? = 0.0,
    @SerializedName("period_min")
    val periodMin: Double? = 0.0,
    @SerializedName("raan")
    val raan: Double? = 0.0,
    @SerializedName("reference_system")
    val referenceSystem: String? = "",
    @SerializedName("regime")
    val regime: String? = "",
    @SerializedName("semi_major_axis_km")
    val semiMajorAxisKm: Double? = 0.0
)