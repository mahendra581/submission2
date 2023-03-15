package com.bangkit.submission2


import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.submission2.databinding.ItemRowBinding
import com.bumptech.glide.Glide

class ListDisease(private val listDisease:List<Disease>) : RecyclerView.Adapter<ListDisease.ListViewHolder>() {
//    private lateinit var onItemClickCallback: OnItemClickCallback

//    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
//        this.onItemClickCallback = onItemClickCallback
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
         holder.bind(listDisease[position])
//        val (name, description, photo,date) = listDisease[position]
//        holder.binding.tvItemName.text = name
//        holder.binding.tvItemDescription.text = description
//        holder.binding.tvItemDate.text = date
//        holder.itemView.setOnClickListener {
//            onItemClickCallback.onItemClicked(listDisease[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = listDisease.size

    class ListViewHolder(var binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(userData: Disease){
            binding.apply {
                Glide.with(itemView)
                    .load(userData.photo) // URL Gambar
                    .into(binding.imgItemPhoto) // imageView mana yang akan diterapkan
                binding.tvItemName.text = userData.name
                binding.tvItemDescription.text = userData.description
                binding.tvItemDate.text = userData.date
            }
            itemView.setOnClickListener{
                val intentToDetail = Intent(itemView.context, DetailActivity::class.java)
                intentToDetail.putExtra("DATA", userData)
                itemView.context.startActivity(intentToDetail)
            }
        }

    }

//    interface OnItemClickCallback {
//        fun onItemClicked(data: Disease)
//    }

}