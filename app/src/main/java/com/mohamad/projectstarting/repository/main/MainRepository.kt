package com.mohamad.projectstarting.repository.main

import androidx.lifecycle.LiveData
import com.mohamad.projectstarting.api.GenericResponse
import com.mohamad.projectstarting.api.OpenApiAuthMainService
import com.mohamad.projectstarting.api.network_responses.LoginResponse
import com.mohamad.projectstarting.api.network_responses.RegistrationResponse
import com.mohamad.projectstarting.repository.JobManager
import com.mohamad.projectstarting.repository.NetworkBoundResource
import com.mohamad.projectstarting.session.SessionManager
import com.mohamad.projectstarting.ui.main.state.MainViewState
import com.mohamad.projectstarting.util.ApiSuccessResponse
import com.mohamad.projectstarting.util.DataState
import com.mohamad.projectstarting.util.GenericApiResponse
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.Job
import javax.inject.Inject

class MainRepository
@Inject
constructor(
    val openApiMainService: OpenApiAuthMainService,
    val sessionManager: SessionManager

) : JobManager(
    "MainRepository"
) {

    @InternalCoroutinesApi
    fun register(
        email: String,
        username: String,
        password: String,
        confirmPassword: String
    ): LiveData<DataState<MainViewState>> {

        return object : NetworkBoundResource<GenericResponse, Any, MainViewState>(
            sessionManager.isConnectedToTheInternet(),
            true,
            false,
            true
        ) {
            override suspend fun createCacheRequestAndReturn() {
                TODO("Not yet implemented")
            }

            override fun createCall(): LiveData<GenericApiResponse<GenericResponse>> {

                return openApiMainService.register(email, username, password, confirmPassword)
            }

            override fun loadFromCache(): LiveData<MainViewState> {
                TODO("Not yet implemented")
            }

            override suspend fun updateLocalDb(cacheObject: Any?) {
                TODO("Not yet implemented")
            }

            override fun setJob(job: Job) {

                addjob("register", job)
            }

            override suspend fun handleApiSuccessResponse(response: ApiSuccessResponse<GenericResponse>) {

                println("finish : ${response.body.response}")
                onCompleteJob(
                    DataState.data(
                        MainViewState(
                            genericResponse = response.body
                        )
                    )
                )
            }

        }.asLiveData()
    }
}