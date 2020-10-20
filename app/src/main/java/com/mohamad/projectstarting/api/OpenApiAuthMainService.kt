package com.mohamad.projectstarting.api

import androidx.lifecycle.LiveData
import com.mohamad.projectstarting.api.network_responses.LoginResponse
import com.mohamad.projectstarting.api.network_responses.RegistrationResponse
import com.mohamad.projectstarting.util.GenericApiResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface OpenApiAuthMainService {

    @POST("account/register")
    @FormUrlEncoded
    fun register(
        @Field("email") email: String,
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("password2") password2: String
    ): LiveData<GenericApiResponse<GenericResponse>>

    @POST("account/login")
    fun login(
        @Field("username") email: String,
        @Field("password") password: String
    ): LiveData<GenericApiResponse<LoginResponse>>
}