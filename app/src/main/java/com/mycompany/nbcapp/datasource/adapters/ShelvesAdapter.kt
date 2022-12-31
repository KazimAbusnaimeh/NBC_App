package com.mycompany.nbcapp.datasource.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mycompany.nbcapp.databinding.ItemShelveBinding
import com.mycompany.nbcapp.models.Shelve

class ShelvesAdapter:RecyclerView.Adapter<ShelvesAdapter.ShelvesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShelvesViewHolder {
        return ShelvesViewHolder(ItemShelveBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ShelvesViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private val defferCallback=object :DiffUtil.ItemCallback<Shelve>(){
        override fun areItemsTheSame(oldItem: Shelve, newItem: Shelve): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: Shelve, newItem: Shelve): Boolean {
            return newItem==oldItem
        }
    }
    private val differ=AsyncListDiffer(this,defferCallback)

    inner class ShelvesViewHolder(private val binding: ItemShelveBinding):ViewHolder(binding.root){
        fun bind(shelve:Shelve){
            binding.data=shelve
        }
    }
}