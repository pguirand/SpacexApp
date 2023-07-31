package com.pierretest.spacexapp.data.models


import com.google.gson.annotations.SerializedName

data class FirstStageModel(
    @SerializedName("cores")
    val cores: List<CoreModel?>? = listOf()
)