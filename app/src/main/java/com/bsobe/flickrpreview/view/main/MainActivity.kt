package com.bsobe.flickrpreview.view.main

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bsobe.flickrpreview.R
import com.bsobe.flickrpreview.databinding.ActivityMainBinding
import com.bsobe.flickrpreview.view.base.BaseActivity
import com.bsobe.flickrpreview.viewmodel.main.MainViewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun getViewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun setViewBinding() {
        viewBinding?.viewModel = viewModel
    }

    override fun onViewLoad() {
        viewBinding?.rvPhotos?.layoutManager = LinearLayoutManager(this)

        viewModel?.getResponseLiveData()?.observe(this, Observer {
            viewBinding?.rvPhotos?.adapter = MainPhotosAdapter(it.photos!!.photoList) { photoModel ->
                viewModel?.onClickedPhoto(photoModel)
            }
        })

        viewModel?.getPhotoModelLiveData()?.observe(this, Observer {
            /*
            val intent = Intent(this@MainActivity, PhotoActivity::class.java)
            intent.putExtra("photoModel", it)
            startActivity(intent)
             */
        })

        viewModel?.getErrorLiveData()?.observe(this, Observer {
            showErrorDialog(it.message)
        })

        viewModel?.getPhotos()
    }

    private fun showErrorDialog(message: String?) {

    }
}
