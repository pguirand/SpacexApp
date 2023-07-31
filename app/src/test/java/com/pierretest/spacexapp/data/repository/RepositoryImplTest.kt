package com.pierretest.spacexapp.data.repository

import com.pierretest.spacexapp.data.remote.ApiCall
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class RepositoryImplTest {

    lateinit var repository: Repository

    @Mock
    lateinit var apiCall: ApiCall

    @Before
    fun startUp() {
        MockitoAnnotations.openMocks(this)
        repository = RepositoryImpl(apiCall)
    }



}