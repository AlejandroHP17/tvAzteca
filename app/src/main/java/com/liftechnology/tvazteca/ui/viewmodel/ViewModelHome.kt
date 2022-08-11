package com.liftechnology.tvazteca.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.liftechnology.tvazteca.data.model.responseContent.Data
import com.liftechnology.tvazteca.data.respository.RepositoryInfo
import com.liftechnology.tvazteca.data.respository.RepositoryTvAzteca
import com.liftechnology.tvazteca.model.ListenerHome
import com.liftechnology.tvazteca.model.ListenerInfo
import com.liftechnology.tvazteca.ui.utils.CoroutineItems

class ViewModelHome(application: Application):AndroidViewModel(application) {

    var listener: ListenerHome?= null
    var listenerInfo : ListenerInfo ?= null

    fun getItems (){
        CoroutineItems.main {
            val response = RepositoryTvAzteca().getItems()
            if (response.isSuccessful){
                listener?.onSuccess(response.body()?.items!!)
            }else{
                listener?.onError("Falló la respuesta")
            }
        }
    }

    fun getInfo(){
        val response = RepositoryInfo().getInfo()
        if (response.isSuccessful){
            listenerInfo?.onSuccess(response.body()?.data!!)
        }else{
            listenerInfo?.onError("Falló la respuesta")
        }
    }
}