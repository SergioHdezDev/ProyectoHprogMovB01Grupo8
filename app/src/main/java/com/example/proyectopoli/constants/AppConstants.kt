package com.example.proyectopoli.constants

import com.example.proyectopoli.model.CardPhoto

const val INFO_APP = "INFO-APP"

fun formatUrl(url:String): String {
    val formattedUrl =
        if (!url.startsWith("http://") &&
            !url.startsWith("https://")) {
            "https://$url"
        } else {
            url
        }
    return formattedUrl
}

fun generateDatePhotos(start: Int): List<CardPhoto> {
    val photos = listOf(
        CardPhoto(
            id = 1,
            title = "Sentadillas",
            description = "Fortalece piernas y glúteos con este ejercicio básico.",
            img = "sentadilla",
            duration = 12.0,
            status = false,
            instruction = "Coloca los pies al ancho de los hombros y baja como si te sentaras en una silla.",
            calories = 50
        ),
        CardPhoto(
            id = 2,
            title = "Flexiones",
            description = "Trabaja el pecho, brazos y core.",
            img = "flexiones",
            duration = 10.0,
            status = false,
            instruction = "Mantén el cuerpo recto mientras bajas y subes.",
            calories = 60
        ),
        CardPhoto(
            id = 3,
            title = "Plancha",
            description = "Desafía tu resistencia y fortalece el core.",
            img = "plancha.jpg",
            duration = 30.0,
            status = false,
            instruction = "Mantén una posición recta apoyándote en tus antebrazos y dedos de los pies.",
            calories = 40
        ),
        CardPhoto(
            id = 4,
            title = "Zancadas",
            description = "Tonifica piernas y glúteos.",
            img = "zancadas",
            duration = 10.0,
            status = false,
            instruction = "Da un paso adelante y baja la rodilla trasera hacia el suelo.",
            calories = 45
        ),
        CardPhoto(
            id = 5,
            title = "Puente de glúteos",
            description = "Fortalece glúteos y lumbar.",
            img = "puente_gluteos",
            duration = 10.0,
            status = false,
            instruction = "Acostado boca arriba, eleva las caderas apretando los glúteos.",
            calories = 35
        ),
        CardPhoto(
            id = 6,
            title = "Saltos con cuerda",
            description = "Mejora la resistencia cardiovascular.",
            img = "salto",
            duration = 20.0,
            status = false,
            instruction = "Salta a ritmo constante durante el tiempo indicado.",
            calories = 100
        ),
        CardPhoto(
            id = 7,
            title = "Mountain Climbers",
            description = "Ejercicio dinámico para el core y piernas.",
            img = "mountain_climbers.jpg",
            duration = 15.0,
            status = false,
            instruction = "Desde posición de plancha, lleva las rodillas al pecho alternadamente.",
            calories = 80
        ),
        CardPhoto(
            id = 8,
            title = "Bíceps con botellas de agua",
            description = "Fortalece tus brazos con objetos caseros.",
            img = "botella_agua",
            duration = 12.0,
            status = false,
            instruction = "Sujeta una botella en cada mano y flexiona los brazos.",
            calories = 25
        ),
        CardPhoto(
            id = 9,
            title = "Estiramiento de piernas",
            description = "Relaja y mejora la flexibilidad.",
            img = "botella_agua",
            duration = 10.0,
            status = false,
            instruction = "Lleva tus manos hacia los pies manteniendo las piernas estiradas.",
            calories = 10
        ),
        CardPhoto(
            id = 10,
            title = "Abdominales cortos",
            description = "Fortalece la parte superior de los abdominales.",
            img = "abdominales1",
            duration = 12.0,
            status = false,
            instruction = "Acuéstate boca arriba y eleva el torso ligeramente.",
            calories = 30
        )
    )
    val end = 10
    return photos.subList(start, end);
}