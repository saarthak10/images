package com.learn.assignment.ui.imageviews

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.learn.assignment.BR
import com.learn.assignment.R
import com.learn.assignment.base.BaseViewHolder
import com.learn.assignment.data.model.ImagesListResponse
import com.learn.assignment.databinding.RowItemImageViewBinding
import com.squareup.picasso.Picasso

class ImageViewsAdapter(val mViewModel: ImageViewsViewModel): RecyclerView.Adapter<BaseViewHolder<ImagesListResponse.Hit>>() {
    private var isLoaderVisible = false
    private val mDataList = mutableListOf<ImagesListResponse.Hit>()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ImagesListResponse.Hit> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.row_item_image_view,
            parent,
            false
        )
        return UserListViewHolder(binding as RowItemImageViewBinding)

    }


    override fun onBindViewHolder(holder: BaseViewHolder<ImagesListResponse.Hit>, position: Int) {

        if (holder is UserListViewHolder) {
            val data = mDataList[position]
            holder.bindData(data)
        }


    }


    fun updateList(list: List<ImagesListResponse.Hit>) {
        mDataList.clear()
        mDataList.addAll(list)
        notifyDataSetChanged()
    }


    private fun getItem(position: Int): ImagesListResponse.Hit {
        return mDataList[position]
    }

    fun addLoading() {
        isLoaderVisible = true
        mDataList.add(ImagesListResponse.Hit())
        notifyItemInserted(mDataList.size - 1)

    }



    override fun getItemCount(): Int {
        return mDataList.size
    }
    inner class UserListViewHolder(val binding: RowItemImageViewBinding): BaseViewHolder<ImagesListResponse.Hit>(binding.root){
        fun bindData(itemData:ImagesListResponse.Hit) {
            binding.setVariable(BR.viewModel, mViewModel)
            Picasso.get().load(itemData.webformatURL).into(binding.ivImage)


            binding.executePendingBindings()
        }




    }
    inner class ProgressViewHolder(binding: ViewDataBinding) :
        BaseViewHolder<ImagesListResponse.Hit>(binding.root)


}