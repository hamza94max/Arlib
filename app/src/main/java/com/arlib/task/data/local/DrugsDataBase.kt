package com.arlib.task.data.local


import androidx.room.Database
import androidx.room.RoomDatabase
import com.arlib.task.domain.models.Drug


@Database(entities = [Drug::class], version = 1, exportSchema = false)
abstract class DrugsDataBase : RoomDatabase() {

    abstract fun getDrugsDao(): DrugsDao

}