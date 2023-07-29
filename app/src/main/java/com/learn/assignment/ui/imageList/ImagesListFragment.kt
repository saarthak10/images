package com.learn.assignment.ui.imageList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.learn.assignment.R
import com.learn.assignment.databinding.FragmentImagesListBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ImagesListFragment : Fragment() {

    lateinit var binding:FragmentImagesListBinding

    @Inject
    lateinit var viewModel: ImagesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentImagesListBinding.inflate(inflater, container,false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_images_list,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    }

}