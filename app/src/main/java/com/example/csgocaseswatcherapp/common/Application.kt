package com.example.csgocaseswatcherapp

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class CsGoCaseWatcherAppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}