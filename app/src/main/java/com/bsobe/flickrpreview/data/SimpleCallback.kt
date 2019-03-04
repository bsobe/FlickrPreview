package com.bsobe.flickrpreview.data

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface SimpleCallback<M> : Callback<M> {

    fun onReceived(response: M)

    fun onFailure(error: Throwable)

    override fun onResponse(call: Call<M>, response: Response<M>) {
        if (response.isSuccessful) {
            onReceived(response.body() as M)
        } else {
            onFailure(Constants.SERVICE_ERROR)
        }
    }

    override fun onFailure(call: Call<M>, t: Throwable) {
        onFailure(t)
    }
}