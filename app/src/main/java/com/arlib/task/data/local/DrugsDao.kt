package com.arlib.task.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arlib.task.domain.models.Drug

@Dao
interface DrugsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrug(vararg drug: Drug)


    @Query("SELECT * FROM drugs_table")
    suspend fun getAllDrugs(): List<Drug>


    @Query("DELETE FROM drugs_table")
    suspend fun deleteAllDrugs()
}