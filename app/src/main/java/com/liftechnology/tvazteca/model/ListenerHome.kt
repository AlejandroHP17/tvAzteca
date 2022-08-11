package com.liftechnology.tvazteca.model

import com.liftechnology.tvazteca.data.model.responseTvAzteca.Item

interface ListenerHome {

    fun itemClicked(item: Item, position: Int)

    fun onSuccess(items: List<Item>)
    fun onError(msg: String)

}