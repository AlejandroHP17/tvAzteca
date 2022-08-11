package com.liftechnology.tvazteca.data.respository

import com.liftechnology.tvazteca.data.model.responseContent.ResponseContent
import com.liftechnology.tvazteca.data.service.ApiInfo
import retrofit2.Response

class RepositoryInfo {
    suspend fun getInfo(name:String): Response<ResponseContent> {
        return ApiInfo().getInfo(name)
    }
}