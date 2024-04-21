package com.arlib.task.domain.usecase

import com.arlib.task.domain.models.Drug
import com.arlib.task.domain.repo.DrugsRepo
import kotlinx.coroutines.flow.Flow

class GetDrugsUseCase(private val drugsRepo: DrugsRepo) {

    suspend operator fun invoke(): Flow<List<Drug>> {
        drugsRepo.cachingDrugs()
        return drugsRepo.getDrugsFromDb()
    }


}