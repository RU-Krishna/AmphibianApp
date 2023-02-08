package com.example.amphibians

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.amphibians.ui.theme.AmphibiansApp
import com.example.amphibians.ui.theme.AmphibiansTheme
import com.example.amphibians.ui.theme.screen.AmphibiansUiState
import com.example.amphibians.ui.theme.screen.AmphibiansViewModel
import com.example.amphibians.ui.theme.screen.HomeScreen
import com.example.amphibians.ui.theme.screen.TestSync
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AmphibiansUiTest{

    @get: Rule
    val composeTestRule = createComposeRule()


    @Test
    fun imageOnCard_RoraimaBushToadImage_imagePresent() {

        //Set the content for the compose Rule.
        composeTestRule.setContent {
            AmphibiansTheme {
                AmphibiansApp()  //Set AmphibiansApp as the main content.
            }
        }

        //Waiting until uiState changes from Loading...
        composeTestRule.waitUntil(60_000) {
            TestSync.uiStateChange

        }

        //After the uiState changes check for the child node with the content description "Roraima Bush Toad".
        composeTestRule
            .onNode(hasAnyChild(hasContentDescription("Roraima Bush Toad")))
            .assertExists()

    }

    @Test
    fun networkChecking_errorScreen_RetryButton() {

        composeTestRule
            .setContent {
                AmphibiansTheme {
                    AmphibiansApp()
                }
            }
        composeTestRule
            .onNode(hasText("Retry") and hasClickAction())
            .assertExists()


    }

}