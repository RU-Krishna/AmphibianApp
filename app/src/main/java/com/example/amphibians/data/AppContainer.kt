package com.example.amphibians.data

import com.example.amphibians.network.AmphibiansApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

//Implementing Dependency Injection on the AppContainer Interface.
interface AppContainer {
    val amphibiansDataRepository: AmphibiansDataRepository
}

/*
*  Concrete Implementation of the AppContainer Interface.
*
*  This implementation uses the Retrofit Library for fetching the data over the internet.
*
* */
class DefaultAppContainer(): AppContainer{

    //Base URL for the data.
    private val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

    //Retrofit Request Builder.
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build();

    //Lazy implementation of Retrofit Service for fetching the data.
    private val retrofitService: AmphibiansApi by lazy {
        retrofit.create(AmphibiansApi::class.java)
    }

    //Lazy implementation of amphibians Data Repository of the AppContainer Interface.
    override val amphibiansDataRepository: AmphibiansDataRepository by lazy {
        NetworkAmphibiansDataRepository(retrofitService)
    }
}