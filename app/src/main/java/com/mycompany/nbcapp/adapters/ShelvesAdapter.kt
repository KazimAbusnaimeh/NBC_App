package com.mycompany.nbcapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mycompany.nbcapp.databinding.ItemShelveBinding
import com.mycompany.nbcapp.models.Shelve

class ShelvesAdapter(private val shelve: List<Shelve>) :
    RecyclerView.Adapter<ShelvesAdapter.ShelvesViewHolder>() {

    lateinit var itemsAdapter: ItemsAdapter
    var shelves: List<Shelve> = shelve


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShelvesViewHolder {
        return ShelvesViewHolder(
            ItemShelveBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ShelvesViewHolder, position: Int) {
        holder.bind(differ.currentList[position], position)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private val defferCallback = object : DiffUtil.ItemCallback<Shelve>() {
        override fun areItemsTheSame(oldItem: Shelve, newItem: Shelve): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: Shelve, newItem: Shelve): Boolean {
            return newItem == oldItem
        }
    }
    val differ = AsyncListDiffer(this, defferCallback)

    inner class ShelvesViewHolder(private val binding: ItemShelveBinding) :
        ViewHolder(binding.root) {
        fun bind(shelve: Shelve, position: Int) {
            itemsAdapter = ItemsAdapter()
            binding.data = shelve
            binding.rvContent.apply {
                adapter = itemsAdapter
            }
            itemsAdapter.differ.submitList(shelves[position].items)
        }
    }
}