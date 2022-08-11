package com.liftechnology.tvazteca.ui.view.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liftechnology.tvazteca.R
import com.liftechnology.tvazteca.data.model.responseTvAzteca.Item
import com.liftechnology.tvazteca.databinding.ActivityHomeBinding
import com.liftechnology.tvazteca.model.ListenerHome
import com.liftechnology.tvazteca.ui.adapters.ItemsAdapter
import com.liftechnology.tvazteca.ui.utils.Constants
import com.liftechnology.tvazteca.ui.view.info.InfoActivity
import com.liftechnology.tvazteca.ui.viewmodel.ViewModelHome

class HomeActivity : AppCompatActivity(), ListenerHome {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var  viewModel: ViewModelHome

    // Recycler view
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: ItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Databinding
        binding = DataBindingUtil.setContentView(this,(R.layout.activity_home))
        viewModel = ViewModelProvider(this)[ViewModelHome::class.java]
        binding.vmHome = viewModel
        viewModel.listener = this

        viewModel.getItems()

        binding.apply {
            recyclerView = rvHome
        }
        layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        recyclerView.layoutManager = layoutManager

    }

    override fun itemClicked(item: Item, position: Int) {
        if (item.private == "1"){
            showAlert()
        }else{
            //viewModel.getInfo()
            val intent = Intent(this, InfoActivity::class.java).apply {
                putExtra(Constants.KEY_INFO,item.programa)
            }
            startActivity(intent)
        }
    }

    override fun onSuccess(items: List<Item>) {
        adapter = ItemsAdapter(items, this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun showAlert(){
        val alert = AlertDialog.Builder(this)
        with(alert){
            setTitle(getString(R.string.txt_title_error_dialog))
            setMessage(getString(R.string.txt_error_dialog))
            show()
        }
    }
}