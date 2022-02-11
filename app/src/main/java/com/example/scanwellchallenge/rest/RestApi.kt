package com.example.scanwellchallenge.rest

import com.example.scanwellchallenge.rest.model.ResultApi
import retrofit2.http.GET

interface RestApi {

    @GET("2.2/users?site=stackoverflow")
    suspend fun fetchUserData(): ResultApi

}