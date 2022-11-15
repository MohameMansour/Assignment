package com.assignment.imageList.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.assignment.R
import com.assignment.databinding.FragmentImageListBinding
import com.assignment.imageList.ImageListViewModel
import com.assignment.imageList.adapter.ImageAdapter
import kotlinx.android.synthetic.main.fragment_image_list.*
import com.assignment.imageList.model.Result
import com.assignment.localDataBase.Constants

class ImageListFragment : Fragment(), ImageAdapter.OnImageClickListener {

    lateinit var viewModel: ImageListViewModel
    private lateinit var binding: FragmentImageListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(ImageListViewModel::class.java)
        binding = FragmentImageListBinding.inflate(this.layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initNewLobbyView()
        getNewLobby()
    }

    private fun initNewLobbyView() {
        image_recyclerview.layoutManager = LinearLayoutManager(requireContext())
    }

    fun getNewLobby() {
        viewModel.imageLists.observe(viewLifecycleOwner, Observer {
            image_recyclerview.adapter = ImageAdapter(it.results, this)
        })

        viewModel.getImageList()
    }

    override fun onImageClicked(imageModelItem: Result) {

        activity?.let {

            val bundle = Bundle()

            bundle.putString(Constants.IMAGE_ID, imageModelItem.media[0].media_metadata[0].url)
            bundle.putString(Constants.TITLE, imageModelItem.title)
            bundle.putString(Constants.DESC, imageModelItem.abstract)
            bundle.putString(Constants.CREATED, imageModelItem.published_date)

            findNavController().navigate(R.id.detailsFragment, bundle)

        }

    }


}