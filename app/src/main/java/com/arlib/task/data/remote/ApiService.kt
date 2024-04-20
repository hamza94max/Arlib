package com.arlib.task.data.remote

import com.arlib.task.domain.models.DrugsResponse
import retrofit2.http.GET

interface ApiService {


    @GET("5aef18d7-961c-4327-8eb6-102d51287f30")
    suspend fun getDrugs(): DrugsResponse


}