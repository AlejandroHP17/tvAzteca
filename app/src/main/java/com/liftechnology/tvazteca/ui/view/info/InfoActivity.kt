package com.liftechnology.tvazteca.ui.view.info

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.liftechnology.tvazteca.R
import com.liftechnology.tvazteca.data.model.responseContent.Data
import com.liftechnology.tvazteca.databinding.ActivityInfoBinding
import com.liftechnology.tvazteca.model.ListenerInfo
import com.liftechnology.tvazteca.ui.utils.Constants
import com.liftechnology.tvazteca.ui.view.home.HomeActivity
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

        binding.apply {
            btnReturn.text = getString(R.string.text_btn_title)
        }

        val url = intent.extras?.getString(Constants.KEY_INFO)
        viewModel.getInfo(url!!)
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

    override fun onChanged() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}