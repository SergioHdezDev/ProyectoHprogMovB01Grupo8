package com.example.proyectopoli.model

data class CardPhoto(
    val id: Int,
    val title: String,
    val description: String,
    val img: String,
    val duration: Double,
    var status: Boolean,
    val instruction: String,
    val calories: Int
)

