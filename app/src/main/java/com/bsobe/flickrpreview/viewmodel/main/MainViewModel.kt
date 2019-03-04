package com.bsobe.flickrpreview.viewmodel.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bsobe.flickrpreview.data.RetrofitInstance
import com.bsobe.flickrpreview.data.SimpleCallback
import com.bsobe.flickrpreview.data.model.response.PhotoModel
import com.bsobe.flickrpreview.data.model.response.RecentResponse

class MainViewModel : ViewModel() {

    private var clickedPhotoLiveData: MutableLiveData<PhotoModel> = MutableLiveData()
    private var recentResponseLiveData: MutableLiveData<RecentResponse> = MutableLiveData()
    private var errorLiveData: MutableLiveData<Throwable> = MutableLiveData()

    fun getPhotos() {
        val call = RetrofitInstance.flickrService.getRecent()
        call.enqueue(object : SimpleCallback<RecentResponse> {
            override fun onReceived(response: RecentResponse) {
                recentResponseLiveData.postValue(response)
            }

            override fun onFailure(error: Throwable) {
                errorLiveData.postValue(error)
            }
        })
    }

    fun onClickedPhoto(clickedPhoto: PhotoModel) {
        clickedPhotoLiveData.postValue(clickedPhoto)
    }

    fun getPhotoModelLiveData(): MutableLiveData<PhotoModel> = clickedPhotoLiveData
    fun getResponseLiveData(): MutableLiveData<RecentResponse> = recentResponseLiveData
    fun getErrorLiveData(): MutableLiveData<Throwable> = errorLiveData
}