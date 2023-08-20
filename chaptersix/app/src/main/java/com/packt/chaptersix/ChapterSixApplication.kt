package com.packt.chaptersix

import android.app.Application
import com.packt.chaptersix.di.appModules
import org.koin.core.context.startKoin

class ChapterSixApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModules)
        }
    }
}