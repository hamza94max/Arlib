package com.arlib.task.di

import com.arlib.task.data.local.DrugsDataBase
import com.arlib.task.data.remote.ApiService
import com.arlib.task.data.repoImpl.DrugsRepoImpl
import com.arlib.task.domain.repo.DrugsRepo
import com.arlib.task.utils.NetworkHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideDrugsRepo(
        apiService: ApiService,
        networkHelper: NetworkHelper,
        dataBase: DrugsDataBase
    ): DrugsRepo {
        return DrugsRepoImpl(apiService, networkHelper = networkHelper, drugsDataBase = dataBase)
    }

}