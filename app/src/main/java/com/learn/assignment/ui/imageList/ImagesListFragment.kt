package com.learn.assignment.ui.imageList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.learn.assignment.R
import com.learn.assignment.data.model.ImagesListResponse
import com.learn.assignment.databinding.FragmentImagesListBinding
import com.learn.assignment.utils.Constants
import com.learn.assignment.utils.Constants.BundleDestination.POSTION
import com.learn.assignment.utils.OnItemClickListener
import com.learn.assignment.utils.PaginationHandler
import com.learn.assignment.utils.isAddLoading
import com.learn.assignment.utils.navigateToImagesViewsScreen
import com.learn.assignment.utils.showToast
import dagger.hilt.android.AndroidEntryPoint
import java.io.Serializable
import java.net.URLEncoder
import javax.inject.Inject

@AndroidEntryPoint
class ImagesListFragment : Fragment() {

    //region Variable
    private var mCountTotal = 0
    private var mPage: Int = 1
    private var mImageList: MutableList<ImagesListResponse.Hit?> =
        mutableListOf<ImagesListResponse.Hit?>()
    lateinit var binding: FragmentImagesListBinding
    val mAdapter by lazy {
        ImageListAdapter(viewModel, object : OnItemClickListener {
            override fun onItemClick(position: Int, itemDetail: ImagesListResponse.Hit) {
                val bundle = Bundle()
                bundle.putSerializable(
                    Constants.BundleDestination.IMAGE_ITEM, itemDetail
                )
                bundle.putSerializable(
                    Constants.BundleDestination.IMAGE_LIST_KEY, mImageList.toList() as Serializable
                )
                bundle.putInt(POSTION, position)

                requireActivity().navigateToImagesViewsScreen(bundle)
            }

        })
    }
    private lateinit var mPaginationHandler: PaginationHandler
    @Inject
    lateinit var viewModel: ImagesListViewModel
    //endregion


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentImagesListBinding.inflate(inflater, container,false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_images_list,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRecyclerView()
        observeUserListResponse()
        handlingSearch()
        viewModel.getImageList("", page = mPage)


    }
    //Method to intialize Recycle View
    fun initRecyclerView() {
        //layout manager
        val llm = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rcvImageList.layoutManager = llm
        binding.rcvImageList.itemAnimator = DefaultItemAnimator()
        binding.rcvImageList.adapter = mAdapter
        mPaginationHandler =
            object : PaginationHandler(llm, Constants.PAGINATION.THRESHOLD) {
                override fun onLoadMore(page: Int, totalItemsCount: Int) {
                    if (totalItemsCount <= mCountTotal) {
                        mPage = page
                        viewModel.getImageList(binding.tvSearch.text.toString(),mPage)

                    }
                }
            }
        binding.rcvImageList.addOnScrollListener(mPaginationHandler)
    }

    ///Method to imageView List
    fun observeUserListResponse(){
        viewModel.imageList.observe(viewLifecycleOwner) {it ->
            mCountTotal += it.size

            it.let { list ->
                if (mPage == 1) {
                    mImageList.clear()
                } else {
                    mAdapter.removeLoading()
                }
                if (list.isNotEmpty()) {
                    //add data to alert list
                    mImageList.addAll(list)
                    //hide no data view
                    //hideEmptyView()
                    //update list
                    mAdapter.updateList(mImageList)

                    if (mPage.isAddLoading(mCountTotal)) {
                        mAdapter.addLoading()
                    }
                }

                if (mImageList.size == 0) {
                    //show no data view
                    //showEmptyView()
                    mAdapter.clearList()
                }
            }
        }
    }
    fun handlingSearch(){
        binding.btnSearch.setOnClickListener {
            if(binding.tvSearch.text?.isNotEmpty()!!) {
                mAdapter.clearList()
                val url = URLEncoder.encode(binding.tvSearch.text.toString())
                mPage = 1
                mCountTotal = 0
                mPaginationHandler.resetState()
                viewModel.getImageList(url, page = mPage)
            }
        }
    }
}