package com.pierretest.spacexapp.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import com.pierretest.spacexapp.data.models.SingleLaunchModel
import androidx.lifecycle.viewModelScope
import com.pierretest.spacexapp.data.models.CompanyInfoModel
import com.pierretest.spacexapp.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchesViewModel @Inject constructor(private val repository: Repository) : ViewModel(){

    private val _listAllLaunches = MutableStateFlow<List<SingleLaunchModel>>(emptyList())
    private val _listSearchLaunches = MutableStateFlow<List<SingleLaunchModel>>(emptyList())
    private val _companyInfo  = MutableStateFlow(CompanyInfoModel())

    init {
        getAllLaunches()
        getCompanyInfo()
        searchLaunchByYear(year = "")
    }

    val listSearchLaunches : StateFlow<List<SingleLaunchModel>> = _listSearchLaunches
    val listAllLaunches : StateFlow<List<SingleLaunchModel>> = _listAllLaunches
    val companyInfo : StateFlow<CompanyInfoModel>
        get() = _companyInfo


    fun getCompanyInfo() {
        viewModelScope.launch {

            try {
                val companyDetails = repository.getCompanyInfo()
                _companyInfo.value = companyDetails
            } catch (e : Exception) {
                e.printStackTrace()
                Log.e("error", e.message?:"Unexpected Error occurred")

            }
        }
    }

    fun getAllLaunches() {

        viewModelScope.launch {
            try {
                val launchList = repository.getAllLaunches()
                _listAllLaunches.value = launchList
            } catch (e : Exception) {
                Log.e("error", e.message?:"Unexpected Error occurred")
            }
        }
    }

//    fun getSortedDataByProperty(property: String, ascending: Boolean): List<SingleLaunchModel> {
//        return when (property) {
//            "id" -> if (ascending) _listSearchLaunches. { it.id } else apiDataList.sortedByDescending { it.id }
//            "name" -> if (ascending) apiDataList.sortedBy { it.name } else apiDataList.sortedByDescending { it.name }
//            "value" -> if (ascending) apiDataList.sortedBy { it.value } else apiDataList.sortedByDescending { it.value }
//            else -> apiDataList
//
////            _listSearchLaunches = when (property) {
////                "year" -> if (ascending) searchLaunches.sortedBy { it.launchYear } else searchLaunches.sortedByDescending { it.launchYear }
////                "success" -> if (ascending) searchLaunches.sortedBy { it.launchSuccess } else searchLaunches.sortedByDescending { it.launchSuccess }
////                else -> searchLaunches
////        }
//    }

    @SuppressLint("SuspiciousIndentation")
    fun searchLaunchByYear(year: String, makeSort: Boolean=false, property: String="", ascending: Boolean = true) {
        viewModelScope.launch {
            try {
                val searchLaunches = repository.searchLaunchByYear(year)
//                if (makeSort) {
                    when (property) {
                        "year" -> if (ascending) searchLaunches.sortedBy { it.launchYear } else searchLaunches.sortedByDescending { it.launchYear }
                        "success" -> if (ascending) searchLaunches.sortedBy { it.launchSuccess } else searchLaunches.sortedByDescending { it.launchSuccess }
                        else -> searchLaunches
                    }
//                }
                _listSearchLaunches.value = searchLaunches

            } catch (e : Exception) {
            Log.e("error", e.message ?: "Unexpected Error occurred")
            e.printStackTrace()
            _listSearchLaunches.value = listOf()

        }
    }
}



}