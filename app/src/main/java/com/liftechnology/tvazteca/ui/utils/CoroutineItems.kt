package com.liftechnology.tvazteca.ui.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object CoroutineItems {

    fun main(work: suspend  (() -> Unit)) = CoroutineScope(Dispatchers.Main).launch {
        work()
    }
}