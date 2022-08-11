package com.liftechnology.tvazteca.data.respository

import com.liftechnology.tvazteca.data.model.responseTvAzteca.ResponseTvAzteca
import com.liftechnology.tvazteca.data.service.ApiTvAzteca
import retrofit2.Response

class RepositoryTvAzteca {
    suspend fun getItems(): Response<ResponseTvAzteca> {
        return ApiTvAzteca().getItems()
    }
}