package com.pierretest.spacexapp.data.repository

import com.pierretest.spacexapp.data.models.CompanyInfoModel
import com.pierretest.spacexapp.data.models.SingleCapsuleModel
import com.pierretest.spacexapp.data.models.SingleLaunchModel

interface Repository {

    suspend fun getAllLaunches() : List<SingleLaunchModel>

    suspend fun getLaunchById(idLaunch : Int ) : SingleLaunchModel

    suspend fun getAllCapsules() : List<SingleCapsuleModel>

    suspend fun getCapsuleById(idCapsule : String) : SingleCapsuleModel

    suspend fun getCompanyInfo() : CompanyInfoModel

    suspend fun searchLaunchByYear(launchYear : String) : List<SingleLaunchModel>

}