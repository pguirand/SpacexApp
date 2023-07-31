package com.pierretest.spacexapp.data.models


import com.google.gson.annotations.SerializedName

data class RocketModel(
    @SerializedName("fairings")
    val fairings: FairingsModel? = FairingsModel(),
    @SerializedName("first_stage")
    val firstStage: FirstStageModel? = FirstStageModel(),
    @SerializedName("rocket_id")
    val rocketId: String? = "",
    @SerializedName("rocket_name")
    val rocketName: String? = "",
    @SerializedName("rocket_type")
    val rocketType: String? = "",
    @SerializedName("second_stage")
    val secondStage: SecondStageModel? = SecondStageModel()
)