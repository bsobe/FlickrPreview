package com.bsobe.flickrpreview.view.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

abstract class BaseActivity<VM : ViewModel, VB : ViewDataBinding> : AppCompatActivity() {

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModelClass(): Class<VM>

    protected var viewBinding: VB? = null
    protected var viewModel: VM? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, getLayoutId())
        viewModel = ViewModelProviders.of(this).get(getViewModelClass())
        setViewBinding()
        onViewLoad()
    }

    abstract fun setViewBinding()

    abstract fun onViewLoad()
}