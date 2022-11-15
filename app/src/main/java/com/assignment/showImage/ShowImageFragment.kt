package com.assignment.showImage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.assignment.R
import com.assignment.databinding.FragmentShowImageBinding
import com.assignment.localDataBase.Constants
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.LazyHeaders

import com.bumptech.glide.load.model.GlideUrl

class  ShowImageFragment : Fragment() {

    private lateinit var binding: FragmentShowImageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val image = arguments?.getString(Constants.IMAGE_ID) ?: ""

        binding = FragmentShowImageBinding.inflate(inflater, container, false)

        val url = GlideUrl(
            image, LazyHeaders.Builder()
                .addHeader("User-Agent", "your-user-agent")
                .build()
        )

        Glide
            .with(binding.root.context)
            .load(url)
            .placeholder(R.drawable.image_placeholder)
            .into(binding.fullImage)

        binding.fullImage


        return binding.root
    }

}