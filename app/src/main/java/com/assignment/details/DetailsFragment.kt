package com.assignment.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.assignment.R
import com.assignment.databinding.FragmentDetailsBinding
import com.assignment.databinding.FragmentShowImageBinding
import com.assignment.localDataBase.Constants
import com.bumptech.glide.Glide

class DetailsFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentDetailsBinding
    var image : String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        image = arguments?.getString(Constants.IMAGE_ID) ?: ""
        val title = arguments?.getString(Constants.TITLE) ?: ""
        val desc = arguments?.getString(Constants.DESC) ?: ""
        val created = arguments?.getString(Constants.CREATED) ?: ""

        binding = FragmentDetailsBinding.inflate(inflater, container, false)


        binding.createdTextview.setText(created)
        binding.nameTextview.setText(title)
        binding.jobTextview.setText(desc)

        Glide
            .with(binding.root.context)
            .load(image)
            .into(binding.profileDoctorImage)


        binding.profileDoctorImage.setOnClickListener(this)
        return binding.root

    }

    override fun onClick(p0: View?) {

        when (p0?.id) {
            R.id.profile_doctor_image -> {
                val bundle = Bundle()
                bundle.putString(Constants.IMAGE_ID, image)
                findNavController().navigate(R.id.action_showFragment, bundle)
            }
        }
    }

}