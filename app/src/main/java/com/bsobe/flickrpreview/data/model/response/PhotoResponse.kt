package com.bsobe.flickrpreview.data.model.response

import com.google.gson.annotations.SerializedName

data class PhotosResponse(
        val page: Int,
        val pages: Int,
        @SerializedName("perpage") val photoCountOfPage: Int,
        @SerializedName("total") val totalPhotoCount: Int,
        @SerializedName("photo") val photoList: List<PhotoModel>
)