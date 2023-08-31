package com.packt.chapterseven

import android.app.Application
import com.packt.chapterseven.di.appModules
import org.koin.core.context.startKoin

class ChapterSevenApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModules)
        }
    }
}