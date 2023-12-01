package com.packt.chapterfourteen

import android.app.Application
import com.packt.chapterfourteen.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin

class ChapterFourteenApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            workManagerFactory()
            modules(appModules)
        }
    }
}