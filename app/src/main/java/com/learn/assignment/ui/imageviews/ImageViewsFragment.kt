package com.learn.assignment.ui.imageviews

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
import com.learn.assignment.databinding.FragmentImageViewsBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ImageViewsFragment : Fragment() {
    lateinit var binding:FragmentImageViewsBinding

    val mAdapter by lazy { ImageViewsAdapter(viewModel)}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // val value = arguments?.getString("clickedItem")
        var value = 1


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
//        binding.rcvImageViews.adapter = mAdapter
    }

    ///Method to imageView List
    fun observeUserListResponse(){
        viewModel.imageList.observe(requireActivity()) {it ->
            if(it.isNotEmpty()) {
                mAdapter.updateList(it)
            }
        }
    }

}
