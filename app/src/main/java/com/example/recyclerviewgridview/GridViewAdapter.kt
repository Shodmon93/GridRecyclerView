package com.example.recyclerviewgridview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewgridview.databinding.ItemListViewBinding

class GridViewAdapter(private var onImageClick: (itemPosition: ImageData) -> Unit) :
    RecyclerView.Adapter<GridViewAdapter.ViewHolder>() {

    private lateinit var binding: ItemListViewBinding
    private var items: MutableList<ImageData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemListViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener {
            onImageClick(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(data: MutableList<ImageData>) {
        this.items = data
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(data: ImageData) {
            Glide
                .with(itemView)
                .load(data.image)
                .into(binding.listViewIMG)

            binding.listViewTXT.text = data.name

        }

    }
}