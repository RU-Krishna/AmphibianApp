package com.example.amphibians.fakeData

import com.example.amphibians.model.Amphibians

//Fake Data source for Business Logic Testing.
object FakeDataSource {
    val listOfAmphibians = listOf(
        Amphibians(
            name = "Roraima Bush Toad",
            type = "Toad",
            imgSrc = "",
            description = ""
        ),
        Amphibians(
            name = "Great Basin Spadefoot",
            type = "Toad",
            imgSrc = "",
            description = ""
        ),
        Amphibians(
            name = "Blue Jeans Frog",
            type = "Frog",
            imgSrc = "",
            description = ""
        )
    )
}