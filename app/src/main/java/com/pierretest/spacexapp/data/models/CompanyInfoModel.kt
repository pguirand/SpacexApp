package com.pierretest.spacexapp.data.models


import com.google.gson.annotations.SerializedName

data class CompanyInfoModel(
    @SerializedName("ceo")
    val ceo: String? = "",
    @SerializedName("coo")
    val coo: String? = "",
    @SerializedName("cto")
    val cto: String? = "",
    @SerializedName("cto_propulsion")
    val ctoPropulsion: String? = "",
    @SerializedName("employees")
    val employees: Int? = 0,
    @SerializedName("founded")
    val founded: Int? = 0,
    @SerializedName("founder")
    val founder: String? = "",
    @SerializedName("headquarters")
    val headquarters: HeadquartersModel? = HeadquartersModel(),
    @SerializedName("launch_sites")
    val launchSites: Int? = 0,
    @SerializedName("links")
    val links: LinksModel? = LinksModel(),
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("summary")
    val summary: String? = "",
    @SerializedName("test_sites")
    val testSites: Int? = 0,
    @SerializedName("valuation")
    val valuation: Double? = 0.0,
    @SerializedName("vehicles")
    val vehicles: Int? = 0
)