package com.example.amphibians.fakeData

import com.example.amphibians.model.Amphibians
import com.example.amphibians.network.AmphibiansApi

//Fake Amphibian Api returning Fake Data.
class FakeAmphibiansApi: AmphibiansApi {

    override suspend fun getData(): List<Amphibians> {
        return FakeDataSource.listOfAmphibians
    }
}