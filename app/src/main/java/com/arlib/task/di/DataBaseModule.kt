package com.arlib.task.di

import android.app.Application
import androidx.room.Room
import com.arlib.task.data.local.DrugsDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDrugsDataBase(app: Application): DrugsDataBase =
        Room.databaseBuilder(app, DrugsDataBase::class.java, "drugs_db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
}