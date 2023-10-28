package com.mustafaozt.retrofitapiexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mustafaozt.retrofitapiexample.adapter.MessageAdapter
import com.mustafaozt.retrofitapiexample.databinding.ActivityMainBinding
import com.mustafaozt.retrofitapiexample.remote.ApiService
import com.mustafaozt.retrofitapiexample.util.RetrofitHelper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private   var _binding:ActivityMainBinding?=null
    private val binding get()=_binding
    private lateinit var viewModel: MainActivityViewModel

    private lateinit var apiService: ApiService
    private lateinit var progressbar:ProgressBar

    private lateinit var recyclerView: RecyclerView
    private val adapter=MessageAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding= ActivityMainBinding.inflate(layoutInflater)
        viewModel=ViewModelProvider(this).get(MainActivityViewModel::class.java)
        setContentView(binding!!.root)

        binding?.let {
            recyclerView=it.recycleviewExample
            recyclerView.layoutManager=LinearLayoutManager(this)
            recyclerView.adapter=adapter


        }
progressbar=binding!!.progressBar

onSubcribe()
viewModel.getMessage()
        viewModel.getMessageList("1")




    }

    private  fun onSubcribe(){
        viewModel.message.observe(this, Observer {

            if(it!=null){

 println(it.body)

            }
            else {
                println("nulll")
            }
        })
    viewModel.isLoading.observe(this, Observer {
        if(!it){
            progressbar.visibility= View.GONE
        }
        else {
            progressbar.visibility=View.VISIBLE

        }
    })
    viewModel.messageList.observe(this, Observer {
        if(it.isSuccessful){
            for( item in 0 until (it.body()?.size ?: 0)){
                println(it.body()?.get(item)?.email)
                adapter.setItems(it.body())
            }
        }
    })
    }


}