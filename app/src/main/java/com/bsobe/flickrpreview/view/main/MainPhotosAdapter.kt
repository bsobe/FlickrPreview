package com.bsobe.flickrpreview.view.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bsobe.flickrpreview.FlickrHelper
import com.bsobe.flickrpreview.R
import com.bsobe.flickrpreview.data.model.response.PhotoModel
import com.bsobe.flickrpreview.databinding.ItemMainPhotoBinding
import com.bumptech.glide.Glide

class MainPhotosAdapter(
        private val photoList: List<PhotoModel>,
        private val onClick: (PhotoModel) -> Unit
) : RecyclerView.Adapter<MainPhotosAdapter.ViewHolder>() {

    fun onClickedPhoto(model: PhotoModel) {
        onClick.invoke(model)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemMainPhotoBinding = DataBindingUtil.inflate(inflater, R.layout.item_main_photo, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photoModel = photoList[holder.adapterPosition]
        holder.mainPhotoCellBinding.photoModel = photoModel
        holder.mainPhotoCellBinding.recyclerViewAdapter = this
        val ivImage = holder.mainPhotoCellBinding.ivImage
        val ivUserImage = holder.mainPhotoCellBinding.ivUserImage
        Glide.with(ivImage.context).load(FlickrHelper.getPhotoUrl(photoModel)).into(ivImage)
        Glide.with(ivUserImage.context).load(FlickrHelper.getUserPhotoUrl(photoModel))
                .error(R.drawable.baseline_person_black_36).into(ivUserImage)
        holder.mainPhotoCellBinding.executePendingBindings()
    }

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        holder.mainPhotoCellBinding.unbind()
        super.onViewDetachedFromWindow(holder)
    }

    class ViewHolder(val mainPhotoCellBinding: ItemMainPhotoBinding) :
            RecyclerView.ViewHolder(mainPhotoCellBinding.root)

}