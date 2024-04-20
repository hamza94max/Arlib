package com.arlib.task.di

import com.arlib.task.data.remote.ApiService
import com.arlib.task.data.repoImpl.DrugsRepoImpl
import com.arlib.task.domain.repo.DrugsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideNewsRepo(
        apiService: ApiService
    ): DrugsRepo {
        return DrugsRepoImpl(apiService)
    }

}