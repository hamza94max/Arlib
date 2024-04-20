package com.arlib.task.domain.usecase

import com.arlib.task.domain.models.DrugsResponse
import com.arlib.task.domain.repo.DrugsRepo

class GetDrugsUseCase(private val drugsRepo: DrugsRepo) {

    suspend operator fun invoke(): DrugsResponse {
        return drugsRepo.getDrugs()
    }


}