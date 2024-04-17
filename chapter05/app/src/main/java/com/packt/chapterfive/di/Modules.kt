package com.packt.chapterfive.di

import com.packt.chapterfive.data.PetsRepository
import com.packt.chapterfive.data.PetsRepositoryImpl
import com.packt.chapterfive.viewmodel.PetsViewModel
import org.koin.dsl.module

val appModules = module {
    single<PetsRepository> { PetsRepositoryImpl() }
    single { PetsViewModel(get()) }
}