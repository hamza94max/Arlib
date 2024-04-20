package com.arlib.task.domain.repo

import com.arlib.task.domain.models.DrugsResponse

interface DrugsRepo {

    suspend fun getDrugs(): DrugsResponse

}