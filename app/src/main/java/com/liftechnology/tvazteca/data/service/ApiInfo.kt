package com.liftechnology.tvazteca.data.service

import com.liftechnology.tvazteca.data.model.responseContent.ResponseContent
import com.liftechnology.tvazteca.data.model.responseTvAzteca.ResponseTvAzteca
import com.liftechnology.tvazteca.ui.utils.Constants
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInfo {
    @GET(Constants.END_POINT_2)
    suspend fun getInfo(): Response<ResponseContent>

    companion object {
        operator fun invoke(): ApiInfo {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.URL_BASE)
                .build()
                .create(ApiInfo::class.java)
        }
    }
}