package com.mustafaozt.retrofitapiexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
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
    private lateinit var textView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding= ActivityMainBinding.inflate(layoutInflater)
        viewModel=ViewModelProvider(this).get(MainActivityViewModel::class.java)
        setContentView(binding!!.root)
        textView= binding!!.textView
progressbar=binding!!.progressBar

onSubcribe()
viewModel.getMessage()




    }

    private  fun onSubcribe(){
        viewModel.message.observe(this, Observer {

            if(it!=null){

 textView.setText(it.body)

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
    }

}