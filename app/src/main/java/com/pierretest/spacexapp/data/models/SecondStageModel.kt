package com.pierretest.spacexapp.data.models


import com.google.gson.annotations.SerializedName

data class SecondStageModel(
    @SerializedName("block")
    val block: Int? = 0,
    @SerializedName("payloads")
    val payloads: List<PayloadModel?>? = listOf()
)