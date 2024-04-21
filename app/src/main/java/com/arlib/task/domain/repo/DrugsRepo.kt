package com.arlib.task.domain.repo

import com.arlib.task.domain.models.Drug
import com.arlib.task.domain.models.DrugsResponse
import kotlinx.coroutines.flow.Flow

interface DrugsRepo {

    suspend fun fetchDrugsFromRemote(): DrugsResponse


    fun getDrugsFromDb(): Flow<List<Drug>>

    suspend fun cachingDrugs()

    suspend fun insertDrug()

    suspend fun deleteDrugs()

}