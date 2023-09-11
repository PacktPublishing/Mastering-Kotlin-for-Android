package com.packt.chaptereight

import android.app.Application
import com.packt.chaptereight.di.appModules
import org.koin.core.context.startKoin

class ChapterEightApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModules)
        }
    }
}