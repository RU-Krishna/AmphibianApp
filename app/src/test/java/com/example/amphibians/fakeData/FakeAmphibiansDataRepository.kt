package com.example.amphibians.fakeData

import com.example.amphibians.data.AmphibiansDataRepository
import com.example.amphibians.model.Amphibians

//Fake Data repository returning Fake Data.
class FakeAmphibiansDataRepository: AmphibiansDataRepository {

    override suspend fun getAmphibiansData(): List<Amphibians> {
        return FakeDataSource.listOfAmphibians
    }
}