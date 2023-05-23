package com.example.barbershop.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.barbershop.databinding.ServicesItemBinding
import com.example.barbershop.model.Services

class ServicesAdapter(
    private val context: Context,
    private val arrayService: MutableList<Services>
) : RecyclerView.Adapter<ServicesAdapter.ServicesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesViewHolder {
        val itemArray = ServicesItemBinding.inflate(LayoutInflater.from(context),parent, false)
        return ServicesViewHolder(itemArray)
    }

    override fun getItemCount() = arrayService.size 

    override fun onBindViewHolder(holder: ServicesViewHolder, position: Int) {
        holder.imgService.setImageResource(arrayService[position].img!!)
        holder.tvService.text = arrayService[position].name
    }


    inner class ServicesViewHolder(binding: ServicesItemBinding) : RecyclerView.ViewHolder(binding.root){
            val imgService = binding.imgService
            val tvService = binding.tvService
    }
}