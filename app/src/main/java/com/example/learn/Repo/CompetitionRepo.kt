package com.example.learn.Repo

import androidx.lifecycle.LiveData
import com.example.learn.APIservice.CompetitionApi
import com.example.learn.models.CompResponse
import com.example.learn.models.Competition
import retrofit2.Response
import javax.inject.Inject

class CompetitionRepo @Inject constructor(private val api: CompetitionApi) {
    suspend fun getCompetitions(): Response<CompResponse> {
        return api.getAllCompetitions()}


}