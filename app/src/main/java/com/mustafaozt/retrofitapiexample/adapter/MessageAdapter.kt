package com.mustafaozt.retrofitapiexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mustafaozt.retrofitapiexample.databinding.MessageRowBinding
import com.mustafaozt.retrofitapiexample.model.Message

class MessageAdapter:RecyclerView.Adapter<MessageAdapter.MessageDailyViewHolder> (){
    private var arrayList:ArrayList<Message>?=null
   inner class MessageDailyViewHolder(val binding:MessageRowBinding):RecyclerView.ViewHolder(binding.root) {

fun setItem(message: Message){
    val name=binding.name
    val body=binding.body
    val email=binding.mail
    name.setText(message.name)
    body.setText(message.body)
    email.setText(message.email)

}
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageDailyViewHolder {
        val binding=MessageRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
return MessageDailyViewHolder(binding)
    }

    override fun getItemCount(): Int {
     return  if(arrayList.isNullOrEmpty()){
           0
       }
        else {
            arrayList!!.size
       }
    }

    override fun onBindViewHolder(holder: MessageDailyViewHolder, position: Int) {
        arrayList?.let { holder.setItem(it.get(position)) }
    }
      fun setItems(arrayList: ArrayList<Message>?){
        this.arrayList=arrayList
        notifyDataSetChanged()
    }
}