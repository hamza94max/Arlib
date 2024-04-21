package com.arlib.task.domain.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

data class DrugsResponse(
    val drugs: List<Drug>
)

@Parcelize
@Entity(tableName = "drugs_table")
data class Drug(
    val dose: String? = "dose",
    @PrimaryKey
    val name: String,
    val strength: String? = "strength"
) : Parcelable