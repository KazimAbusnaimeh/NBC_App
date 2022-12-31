package com.mycompany.nbcapp.datasource.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mycompany.nbcapp.databinding.ItemContentBinding
import com.mycompany.nbcapp.models.Item

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemContentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private val differCallback= object :
    DiffUtil.ItemCallback<Item>(){
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return newItem.title==oldItem.title
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return newItem==oldItem
        }

    }
    private val differ=AsyncListDiffer(this,differCallback)

    inner class ItemViewHolder(private val binding: ItemContentBinding) : ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.data = item
        }
    }

}