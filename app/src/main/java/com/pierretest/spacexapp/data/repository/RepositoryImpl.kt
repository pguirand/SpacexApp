package com.pierretest.spacexapp.data.repository

import com.pierretest.spacexapp.data.models.CompanyInfoModel
import com.pierretest.spacexapp.data.models.SingleCapsuleModel
import com.pierretest.spacexapp.data.models.SingleLaunchModel
import com.pierretest.spacexapp.data.remote.ApiCall

class RepositoryImpl(val apiCall:ApiCall) : Repository {
    override suspend fun getAllLaunches(): List<SingleLaunchModel> {
        return apiCall.getAllLaunches()
    }

    override suspend fun getLaunchById(idLaunch: Int): SingleLaunchModel {
        return apiCall.getLaunchById(idLaunch)
    }

    override suspend fun getAllCapsules(): List<SingleCapsuleModel> {
        return apiCall.getAllCapsules()
    }

    override suspend fun getCapsuleById(idCapsule: String): SingleCapsuleModel {
        return apiCall.getCapsuleById(idCapsule)
    }

    override suspend fun getCompanyInfo(): CompanyInfoModel {
        return apiCall.getCompanyInfo()
    }

    override suspend fun searchLaunchByYear(launchYear: String): List<SingleLaunchModel> {
        return apiCall.getLaunchByYear(launchYear)
    }
}