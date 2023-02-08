package com.example.amphibians.model

import kotlinx.serialization.SerialName

//Data Class for Amphibians Data.
@kotlinx.serialization.Serializable
data class Amphibians(
    val name: String,
    val type: String,
    val description: String,
    @SerialName(value = "img_src")
    val imgSrc: String,
)
