package com.liftechnology.tvazteca.data.respository

import com.liftechnology.tvazteca.data.model.responseContent.ResponseContent
import com.liftechnology.tvazteca.data.model.responseTvAzteca.ResponseTvAzteca
import com.liftechnology.tvazteca.data.service.ApiInfo
import retrofit2.Response

class RepositoryInfo {
    suspend fun getInfo(): Response<ResponseContent> {
        return ApiInfo().getInfo()
    }
}