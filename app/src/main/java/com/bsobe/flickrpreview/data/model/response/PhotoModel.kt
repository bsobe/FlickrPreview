package com.bsobe.flickrpreview.data.model.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PhotoModel(
    @SerializedName("owner") val ownerId: String,
    @SerializedName("title") val title: String,
    @SerializedName("ownername") val ownerName: String,
    @SerializedName("url_m") val urlMedium: String?,
    @SerializedName("url_o") val urlOriginal: String,
    @SerializedName("iconserver") val iconServer: String,
    @SerializedName("iconfarm") val iconFarm: Int
) : Serializable
