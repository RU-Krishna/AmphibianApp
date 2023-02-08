package com.example.amphibians.data

import com.example.amphibians.model.Amphibians
import com.example.amphibians.network.AmphibiansApi

//Interface for Dependency Injection.
interface AmphibiansDataRepository {

    suspend fun getAmphibiansData(): List<Amphibians>;
}

//Repository class for fetching the data over the network.
class NetworkAmphibiansDataRepository(
    private val amphibiansApi: AmphibiansApi
): AmphibiansDataRepository {

    override suspend fun getAmphibiansData() = amphibiansApi.getData()

}