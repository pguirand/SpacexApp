package com.pierretest.spacexapp.data.models


import com.google.gson.annotations.SerializedName

data class TimelineModel(
    @SerializedName("engine_chill")
    val engineChill: Int? = 0,
    @SerializedName("fairing_deploy")
    val fairingDeploy: Int? = 0,
    @SerializedName("first_stage_entry_burn")
    val firstStageEntryBurn: Int? = 0,
    @SerializedName("first_stage_landing")
    val firstStageLanding: Int? = 0,
    @SerializedName("go_for_launch")
    val goForLaunch: Int? = 0,
    @SerializedName("go_for_prop_loading")
    val goForPropLoading: Int? = 0,
    @SerializedName("ignition")
    val ignition: Int? = 0,
    @SerializedName("liftoff")
    val liftoff: Int? = 0,
    @SerializedName("maxq")
    val maxq: Int? = 0,
    @SerializedName("meco")
    val meco: Int? = 0,
    @SerializedName("payload_deploy")
    val payloadDeploy: Int? = 0,
    @SerializedName("prelaunch_checks")
    val prelaunchChecks: Int? = 0,
    @SerializedName("propellant_pressurization")
    val propellantPressurization: Int? = 0,
    @SerializedName("rp1_loading")
    val rp1Loading: Int? = 0,
    @SerializedName("seco-1")
    val seco1: Int? = 0,
    @SerializedName("seco-2")
    val seco2: Int? = 0,
    @SerializedName("second_stage_ignition")
    val secondStageIgnition: Int? = 0,
    @SerializedName("second_stage_restart")
    val secondStageRestart: Int? = 0,
    @SerializedName("stage1_lox_loading")
    val stage1LoxLoading: Int? = 0,
    @SerializedName("stage2_lox_loading")
    val stage2LoxLoading: Int? = 0,
    @SerializedName("stage_sep")
    val stageSep: Int? = 0,
    @SerializedName("webcast_liftoff")
    val webcastLiftoff: Int? = 0
)