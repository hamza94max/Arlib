package com.arlib.task.di

import com.arlib.task.domain.repo.DrugsRepo
import com.arlib.task.domain.usecase.GetDrugsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetCompetitionsUseCase(drugsRepo: DrugsRepo): GetDrugsUseCase {
        return GetDrugsUseCase(drugsRepo)
    }


}
