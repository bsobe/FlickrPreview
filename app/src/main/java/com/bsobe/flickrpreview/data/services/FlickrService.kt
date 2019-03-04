package com.bsobe.flickrpreview.data.services

import com.bsobe.flickrpreview.data.model.response.RecentResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

internal const val URLS = "url_m, url_o, owner_name, icon_server"
internal const val API_KEY = "ec129adfdbf62fb62364d1d4d4b3e209"

interface FlickrService {
    @GET("rest/?method=flickr.photos.getRecent&nojsoncallback=1&format=json")
    fun getRecent(
            @Query("api_key") apiKey: String = API_KEY,
            @Query("extras") extras: String = URLS
    ): Call<RecentResponse>
}