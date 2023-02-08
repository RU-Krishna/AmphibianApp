package com.example.amphibians.ui.theme.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibians.MyApplication
import com.example.amphibians.data.AmphibiansDataRepository
import com.example.amphibians.model.Amphibians
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

//Sealed Interface for the MarsUiState.
sealed interface AmphibiansUiState {

    data class Success(val amphibiansData: List<Amphibians>): AmphibiansUiState

    object Loading: AmphibiansUiState

    object Error: AmphibiansUiState
}

//This class is for test purpose, not belongs to the actual code.
sealed class TestSync {
    companion object {
        var uiStateChange = false
    }
}

/*
*  View Model for the whole application which,
*  interacts with the UI and Data layer.
*
* */
class AmphibiansViewModel(
    private val networkAmphibiansDataRepository: AmphibiansDataRepository
): ViewModel(){

    //Observable for Recomposition.
     var amphibiansUiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
    private set


    //Init block.
    init {
        getData()
    }

    /*
    * This method exposes the fetched data to the UI,
    * and the cause for Recomposition.
    * */
    fun getData() {
        viewModelScope.launch {
            amphibiansUiState = AmphibiansUiState.Loading
            amphibiansUiState = try {
                AmphibiansUiState.Success(networkAmphibiansDataRepository.getAmphibiansData())
            } catch (e: IOException) {
                AmphibiansUiState.Error
            }catch (e: HttpException) {
                AmphibiansUiState.Error
            }
            TestSync.uiStateChange = true
        }

        TestSync.uiStateChange = false

    }

    companion object {
        /*
        * Factory variable for the companion object[View Model Class],
        * for view Model initialisation.
        * */
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MyApplication)
                val networkAmphibiansDataRepository = application.container.amphibiansDataRepository
                AmphibiansViewModel(networkAmphibiansDataRepository = networkAmphibiansDataRepository)
            }
        }
    }

}