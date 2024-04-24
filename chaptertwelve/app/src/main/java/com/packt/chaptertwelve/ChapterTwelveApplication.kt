package com.packt.chaptertwelve

import android.app.Application
import com.packt.chaptertwelve.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin

class ChapterTwelveApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            workManagerFactory()
            modules(appModules)
        }
    }
}