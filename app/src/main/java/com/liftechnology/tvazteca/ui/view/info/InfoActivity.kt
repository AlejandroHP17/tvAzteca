package com.liftechnology.tvazteca.ui.view.info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.liftechnology.tvazteca.R
import com.liftechnology.tvazteca.data.model.responseContent.Data
import com.liftechnology.tvazteca.databinding.ActivityInfoBinding
import com.liftechnology.tvazteca.model.ListenerInfo
import com.liftechnology.tvazteca.ui.viewmodel.ViewModelHome

class InfoActivity : AppCompatActivity(), ListenerInfo {

    private lateinit var binding: ActivityInfoBinding
    private lateinit var viewModel: ViewModelHome

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //Databinding
        binding = DataBindingUtil.setContentView(this, (R.layout.activity_info))
        viewModel = ViewModelProvider(this)[ViewModelHome::class.java]
        binding.vmInfo = viewModel
        viewModel.listenerInfo = this

        viewModel.getInfo()
    }

    override fun onSuccess(info: List<Data>) {
        info.forEach {
            binding.txtUrl.text = it.url
            binding.txtTitle.text = it.title
        }
    }

    override fun onError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}