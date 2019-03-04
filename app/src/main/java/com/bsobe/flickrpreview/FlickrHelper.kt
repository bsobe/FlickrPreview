package com.bsobe.flickrpreview

import com.bsobe.flickrpreview.data.model.response.PhotoModel

object FlickrHelper {

    fun getUserPhotoUrl(photoModel: PhotoModel): String {
        return "https://farm" + photoModel.iconFarm + ".staticflickr.com/" + photoModel.iconServer + "/buddyicons/" + photoModel.ownerId + "_m.jpg"
    }

    fun getPhotoUrl(photoModel: PhotoModel): String {
        return if (photoModel.urlMedium.isNullOrEmpty()) {
            photoModel.urlOriginal
        } else {
            photoModel.urlMedium!!
        }
    }
}