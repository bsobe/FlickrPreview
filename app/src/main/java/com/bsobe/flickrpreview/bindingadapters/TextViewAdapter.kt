package com.bsobe.flickrpreview.bindingadapters

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter

object TextViewAdapter {

    @JvmStatic
    @BindingAdapter("isVisible")
    fun setIsVisible(view: TextView, value: String?) {
        if (value.isNullOrEmpty()) {
            view.visibility = View.GONE
        } else {
            view.visibility = View.VISIBLE
        }
    }
}
