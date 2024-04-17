package com.packt.chapterfive

import android.app.Application
import com.packt.chapterfive.di.appModules
import org.koin.core.context.startKoin

class ChapterFiveApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModules)
        }
    }
}