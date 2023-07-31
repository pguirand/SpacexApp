package com.pierretest.spacexapp.data.models


import com.google.gson.annotations.SerializedName

data class SingleLaunchModel(
    @SerializedName("crew")
    val crew: Any? = Any(),
    @SerializedName("details")
    val details: String? = "",
    @SerializedName("flight_number")
    val flightNumber: Int? = 0,
    @SerializedName("is_tentative")
    val isTentative: Boolean? = false,
    @SerializedName("launch_date_local")
    val launchDateLocal: String? = "",
    @SerializedName("launch_date_unix")
    val launchDateUnix: Int? = 0,
    @SerializedName("launch_date_utc")
    val launchDateUtc: String? = "",
    @SerializedName("launch_site")
    val launchSite: LaunchSiteModel? = LaunchSiteModel(),
    @SerializedName("launch_success")
    val launchSuccess: Boolean? = false,
    @SerializedName("launch_window")
    val launchWindow: Int? = 0,
    @SerializedName("launch_year")
    val launchYear: String? = "",
    @SerializedName("links")
    val links: LinksModelX? = LinksModelX(),
    @SerializedName("mission_id")
    val missionId: List<Any>? = listOf(),
    @SerializedName("mission_name")
    val missionName: String? = "",
    @SerializedName("rocket")
    val rocket: RocketModel? = RocketModel(),
    @SerializedName("ships")
    val ships: List<String>? = listOf(),
    @SerializedName("static_fire_date_unix")
    val staticFireDateUnix: Int? = 0,
    @SerializedName("static_fire_date_utc")
    val staticFireDateUtc: String? = "",
    @SerializedName("tbd")
    val tbd: Boolean? = false,
    @SerializedName("telemetry")
    val telemetry: TelemetryModel? = TelemetryModel(),
    @SerializedName("tentative_max_precision")
    val tentativeMaxPrecision: String? = "",
    @SerializedName("timeline")
    val timeline: TimelineModel? = TimelineModel(),
    @SerializedName("upcoming")
    val upcoming: Boolean? = false
)