package com.packt.chaptersix.di

import com.packt.chaptersix.data.PetsRepository
import com.packt.chaptersix.data.PetsRepositoryImpl
import com.packt.chaptersix.viewmodel.PetsViewModel
import org.koin.dsl.module

val appModules = module {
    single<PetsRepository> { PetsRepositoryImpl() }
    single { PetsViewModel(get()) }
}