package com.packt.chaptereleven

import androidx.test.core.app.ApplicationProvider
import com.packt.chaptereleven.di.appModules
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.context.GlobalContext.stopKoin
import org.koin.core.logger.Level

class KoinTestRule : TestRule {
    override fun apply(base: Statement?, description: Description?): Statement {
        return object : Statement() {
            override fun evaluate() {
                stopKoin()
                startKoin {
                    androidLogger(Level.ERROR)
                    androidContext(ApplicationProvider.getApplicationContext())
                    modules(appModules)
                }
            }
        }
    }
}