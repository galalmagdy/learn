package com.example.learn.APIservice

import com.example.learn.models.CompResponse
import com.example.learn.models.Competition
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface CompetitionApi {

    @Headers("X-Auth-Token: 1f0c50245af14aeab9d85d0a208b2fe7")
    @GET("v4/competitions")
    suspend fun getAllCompetitions(): Response<CompResponse>
}