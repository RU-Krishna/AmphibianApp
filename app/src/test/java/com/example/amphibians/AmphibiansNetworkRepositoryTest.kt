package com.example.amphibians

import com.example.amphibians.fakeData.FakeAmphibiansDataRepository
import com.example.amphibians.fakeData.FakeDataSource
import com.example.amphibians.rules.TestDispatcherRule
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

//Class for testing the NetworkRepository.
class AmphibiansNetworkRepositoryTest {

    @get: Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun amphibiansNetworkRepository_getAmphibiansData_verifyAmphibiansList() {
        runTest {

            val amphibiansList = FakeAmphibiansDataRepository()

            assertEquals(
                amphibiansList.getAmphibiansData(),
                FakeDataSource.listOfAmphibians
            )
        }
    }
}