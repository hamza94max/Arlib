package com.arlib.task.domain.models

data class DrugsResponse(
    val drugs: List<Drug>
)

data class Drug(
    val dose: String,
    val name: String,
    val strength: String
) : java.io.Serializable