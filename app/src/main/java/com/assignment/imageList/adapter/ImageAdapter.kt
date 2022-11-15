package com.assignment.imageList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.databinding.ItemImageBinding
import com.bumptech.glide.Glide
import com.assignment.imageList.model.Result

class ImageAdapter(
    val imageList: List<Result>,
    val onImageClickListener: OnImageClickListener
) :
    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding =
            ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.imageModel = imageList[position]
        holder.bindViews(position)

        holder.binding.root.setOnClickListener {
            onImageClickListener.onImageClicked(imageList[position])
        }
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    inner class ViewHolder(val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindViews(position: Int) {
            val imagePosition = imageList[position]
            imagePosition.let {

                val fullUrl = imagePosition.media[0].media_metadata[0].url.toString()


                Glide
                    .with(binding.root.context)
                    .load(fullUrl)
                    .into(binding.profileDoctorImage)
            }
        }

    }

    interface OnImageClickListener {
        fun onImageClicked(imageModelItem: Result)
    }
}