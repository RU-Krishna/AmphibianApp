package com.example.amphibians.network

import com.example.amphibians.model.Amphibians
import retrofit2.http.GET

//Interface representing the [REST] Retrofit Request type with the endpoint [photos]
interface AmphibiansApi {

    //Suspend function.
    @GET("amphibians")
    suspend fun getData(): List<Amphibians>;
}