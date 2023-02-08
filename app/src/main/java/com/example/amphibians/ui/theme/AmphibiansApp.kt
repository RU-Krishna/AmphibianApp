package com.example.amphibians.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibians.R
import com.example.amphibians.ui.theme.screen.AmphibiansViewModel
import com.example.amphibians.ui.theme.screen.HomeScreen

/*
* This composable represents the whole screen for the app including TopAppBar.
* */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun AmphibiansApp(modifier: Modifier = Modifier) {
    Scaffold(
         modifier = modifier.fillMaxSize(),
         topBar = {
          TopAppBar(
              title = {
                  Text(  text = stringResource(id = R.string.app_name),
                         style = MaterialTheme.typography.headlineLarge  )
              },
              colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primary)
          )
         }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colorScheme.background

        ) {


            val amphibiansViewModel: AmphibiansViewModel = viewModel(
                factory = AmphibiansViewModel.factory
            )
            HomeScreen(
                amphibiansUiState = amphibiansViewModel.amphibiansUiState,
                retryAction = amphibiansViewModel::getData,
            )
        }
    }
}