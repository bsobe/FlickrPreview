package com.bsobe.flickrpreview

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.MemoryCategory

class App() : Application() {


    override fun onCreate() {
        super.onCreate()
        Glide.get(applicationContext).clearMemory()
        Glide.get(applicationContext).setMemoryCategory(MemoryCategory.HIGH)
    }
}