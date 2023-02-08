package com.example.amphibians

import com.example.amphibians.fakeData.FakeAmphibiansDataRepository
import com.example.amphibians.fakeData.FakeDataSource
import com.example.amphibians.rules.TestDispatcherRule
import com.example.amphibians.ui.theme.screen.AmphibiansUiState
import com.example.amphibians.ui.theme.screen.AmphibiansViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

//Class for testing the ViewModel Class by providing Fake Data.
class AmphibiansViewModelTest {

    @get: Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun amphibiansViewModel_getData_amphibiansUiStateSuccess() {
        runTest {
            val amphibiansViewModel = AmphibiansViewModel(
                FakeAmphibiansDataRepository()
            )

            assertEquals(
                amphibiansViewModel.amphibiansUiState,
                AmphibiansUiState.Success(FakeDataSource.listOfAmphibians)
            )
        }
    }

}