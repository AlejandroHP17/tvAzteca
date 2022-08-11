package com.liftechnology.tvazteca.model

import com.liftechnology.tvazteca.data.model.responseContent.Data
import com.liftechnology.tvazteca.data.model.responseTvAzteca.Item

interface ListenerInfo {

    fun onSuccess(info: List<Data>)
    fun onError(msg: String)

}