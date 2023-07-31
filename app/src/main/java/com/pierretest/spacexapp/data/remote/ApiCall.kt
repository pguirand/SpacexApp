package com.pierretest.spacexapp.data.remote

import com.pierretest.spacexapp.common.ApiDetails
import com.pierretest.spacexapp.data.models.CompanyInfoModel
import com.pierretest.spacexapp.data.models.SingleCapsuleModel
import com.pierretest.spacexapp.data.models.SingleLaunchModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiCall {

    @GET(ApiDetails.ALL_LAUNCHES)
    suspend fun getAllLaunches() : List<SingleLaunchModel>

    @GET(ApiDetails.SINGLE_LAUNCH)
    suspend fun getLaunchById(@Path("id") id : Int) : SingleLaunchModel

    @GET(ApiDetails.SINGLE_CAPSULE)
    suspend fun getCapsuleById(@Query("id")id : String) : SingleCapsuleModel

    @GET(ApiDetails.ALL_CAPSULES)
    suspend fun getAllCapsules() : List<SingleCapsuleModel>

    @GET(ApiDetails.COMPANY_INFO)
    suspend fun getCompanyInfo() : CompanyInfoModel

    @GET(ApiDetails.ALL_LAUNCHES)
    suspend fun getLaunchByYear(@Query("launch_year")year : String) : List<SingleLaunchModel>

}