package com.liftechnology.tvazteca.data.service

import com.liftechnology.tvazteca.data.model.responseContent.ResponseContent
import com.liftechnology.tvazteca.ui.utils.Constants
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInfo {
    @GET(Constants.END_POINT_2)
    suspend fun getInfo(@Path("name") name:String): Response<ResponseContent>

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