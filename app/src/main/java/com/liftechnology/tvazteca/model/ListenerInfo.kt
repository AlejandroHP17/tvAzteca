package com.liftechnology.tvazteca.model

import com.liftechnology.tvazteca.data.model.responseContent.Data

interface ListenerInfo {

    fun onSuccess(info: List<Data>)
    fun onError(msg: String)

    fun onChanged()

}