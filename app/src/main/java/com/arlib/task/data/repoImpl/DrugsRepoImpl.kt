package com.arlib.task.data.repoImpl

import com.arlib.task.data.remote.ApiService
import com.arlib.task.domain.models.DrugsResponse
import com.arlib.task.domain.repo.DrugsRepo

class DrugsRepoImpl(private val apiService: ApiService) : DrugsRepo {

    override suspend fun getDrugs(): DrugsResponse {
        return apiService.getDrugs()
    }
}