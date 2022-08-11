package com.liftechnology.tvazteca.data.service

import com.liftechnology.tvazteca.data.model.responseTvAzteca.ResponseTvAzteca
import com.liftechnology.tvazteca.ui.utils.Constants
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiTvAzteca {
    @GET(Constants.END_POINT)
    suspend fun getItems(): Response<ResponseTvAzteca>

    companion object{
        operator fun invoke():ApiTvAzteca{
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.URL_BASE)
                .build()
                .create(ApiTvAzteca::class.java)
        }
    }
}