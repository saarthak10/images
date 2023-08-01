package com.learn.assignment.ui.imageviews

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.learn.assignment.R
import com.learn.assignment.data.model.ImagesListResponse
import com.learn.assignment.data.model.ImagesListResponse.Hit
import com.learn.assignment.databinding.FragmentImageViewsBinding
import com.learn.assignment.utils.Constants
import dagger.hilt.android.AndroidEntryPoint
import java.io.Serializable
import javax.inject.Inject

@AndroidEntryPoint
class ImageViewsFragment : Fragment() {
    lateinit var binding:FragmentImageViewsBinding

    val mAdapter by lazy { ImageViewsAdapter(viewModel)}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        observeUserListResponse()
        val args = arguments
        viewModel.position.value =  args?.getSerializable(Constants.BundleDestination.POSTION) as
                Int?
        viewModel.imageItem.value = args?.getSerializable(Constants.BundleDestination.IMAGE_ITEM) as Hit?
        viewModel.imageList.value = args?.getSerializable(Constants.BundleDestination.IMAGE_LIST_KEY) as
                MutableList<ImagesListResponse.Hit?>?

    }
    @Inject
    lateinit var viewModel: ImageViewsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentImageViewsBinding.inflate(inflater)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_image_views,container,false)
        return binding.root
    }


    //Method to intialize Recycle View
    fun initRecyclerView() {
        //layout manager
        val llm = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rcvImageViews.layoutManager = llm
        binding.rcvImageViews.itemAnimator = DefaultItemAnimator()
        binding.rcvImageViews.adapter = mAdapter
    }

    ///Method to imageView List
    fun observeUserListResponse(){
        viewModel.imageList.observe(requireActivity()) {it ->
            if(it.isNotEmpty()) {
                mAdapter.updateList(it.toList() as List<Hit>)
                binding.rcvImageViews.scrollToPosition(viewModel.position.value!!)
            }
        }
    }

}
