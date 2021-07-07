package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemBinding
import com.example.myapplication.models.Item
import com.example.myapplication.viewmodels.MainViewModel

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {
    var items = mutableListOf<Item>()

    fun setItemList(items : List<Item>){
        this.items = items.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = ItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val item = items[position]

       holder.binding.titleTv.text = item.title
       holder.binding.descriptionTv.text = item.description




    }

    override fun getItemCount(): Int {
        return items.size
    }


}
class MainViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root){

}
