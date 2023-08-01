package com.learn.assignment.ui.imageList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.learn.assignment.BR
import com.learn.assignment.R
import com.learn.assignment.base.BaseViewHolder
import com.learn.assignment.data.model.ImagesListResponse
import com.learn.assignment.databinding.RowItemImagesBinding
import com.learn.assignment.utils.OnItemClickListener
import com.squareup.picasso.Picasso

class ImageListAdapter(val mViewModel: ImagesListViewModel, private val itemClickListener:
OnItemClickListener
): RecyclerView.Adapter<BaseViewHolder<ImagesListResponse.Hit>>() {
    private var isLoaderVisible = false
    private val mDataList = mutableListOf<ImagesListResponse.Hit?>()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ImagesListResponse.Hit> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.row_item_images,
            parent,
            false
        )
        return UserListViewHolder(binding as RowItemImagesBinding)

    }


    override fun onBindViewHolder(holder: BaseViewHolder<ImagesListResponse.Hit>, position: Int) {

        if (holder is UserListViewHolder) {
            val data = mDataList[position]
            holder.bindData(data!!)
        }


    }


    fun updateList(list: List<ImagesListResponse.Hit?>) {
        mDataList.clear()
        mDataList.addAll(list)
        notifyDataSetChanged()
    }


    private fun getItem(position: Int): ImagesListResponse.Hit {
        return mDataList[position]!!
    }

    fun addLoading() {
        isLoaderVisible = true
        mDataList.add(ImagesListResponse.Hit())
        notifyItemInserted(mDataList.size - 1)

    }
    fun removeLoading() {
        isLoaderVisible = false
        val position: Int = mDataList.size - 1
        val item: ImagesListResponse.Hit? = getItem(position)
        if (item != null) {
            mDataList.removeAt(position)
            notifyItemRemoved(position)
        }
    }
    fun clearList() {
        mDataList.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }
    inner class UserListViewHolder(val binding: RowItemImagesBinding): BaseViewHolder<ImagesListResponse.Hit>(binding.root){
        fun bindData(itemData:ImagesListResponse.Hit) {
            binding.setVariable(BR.viewModel, mViewModel)
            Picasso.get().load(itemData.webformatURL).placeholder(R.drawable.loader).into(binding
                .ivImage)
        binding.clImage.setOnClickListener {
            // Get the position of the clicked item
            val position = adapterPosition

            // Invoke the onItemClick method of the click listener interface
            itemClickListener.onItemClick(position,mDataList[position]!!)


        }

            binding.executePendingBindings()
        }



    }
    inner class ProgressViewHolder(binding: ViewDataBinding) :
        BaseViewHolder<ImagesListResponse.Hit>(binding.root)


}