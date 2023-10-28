package com.mustafaozt.retrofitapiexample.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafaozt.retrofitapiexample.model.Message
import com.mustafaozt.retrofitapiexample.model.MessageList
import com.mustafaozt.retrofitapiexample.remote.ApiService
import com.mustafaozt.retrofitapiexample.util.RetrofitHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val apiService: ApiService

):ViewModel() {
    private val     _isLoading=MutableLiveData<Boolean>()
    val isLoading:LiveData<Boolean>
        get() = _isLoading
    private   val _message= MutableLiveData<Message>()
        val message:LiveData<Message>
    get() = _message
    private   val _messageList= MutableLiveData<Response<MessageList>>()
    val messageList:LiveData<Response<MessageList>>
        get() = _messageList
    fun getMessage(){
        viewModelScope.launch {
            _isLoading.value=(true)
delay(2000)
            val post=apiService.getPostOne()
            _message.postValue(post)
            _isLoading.value=(false)
        }
    }
        fun getMessageList(postId:String){
            viewModelScope.launch {
                _isLoading.value=(true)
                delay(2000)
                val postList=apiService.getPostList(postId)
                _messageList.postValue(postList)
                _isLoading.value=(false)
            }






    }
}