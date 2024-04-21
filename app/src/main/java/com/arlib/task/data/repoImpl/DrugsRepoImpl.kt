package com.arlib.task.data.repoImpl

import com.arlib.task.data.local.DrugsDataBase
import com.arlib.task.data.remote.ApiService
import com.arlib.task.domain.models.Drug
import com.arlib.task.domain.models.DrugsResponse
import com.arlib.task.domain.repo.DrugsRepo
import com.arlib.task.utils.NetworkHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DrugsRepoImpl(
    private val apiService: ApiService,
    private val networkHelper: NetworkHelper,
    private val drugsDataBase: DrugsDataBase
) : DrugsRepo {

    override suspend fun fetchDrugsFromRemote(): DrugsResponse {
        return apiService.getDrugs()
    }

    override fun getDrugsFromDb(): Flow<List<Drug>> = flow {
        emit(drugsDataBase.getDrugsDao().getAllDrugs())
    }

    override suspend fun cachingDrugs() {
        if (drugsDataBase.getDrugsDao().getAllDrugs().isEmpty()) {
            if (networkHelper.isInternetAvailable()) {
                fetchDrugsFromRemote()
                deleteDrugs()
                insertDrug()
            }
        }
    }

    override suspend fun insertDrug() {
        apiService.getDrugs().drugs.map { drug ->
            drugsDataBase.getDrugsDao().insertDrug(drug)
        }
    }

    override suspend fun deleteDrugs() {
        drugsDataBase.getDrugsDao().deleteAllDrugs()
    }
}