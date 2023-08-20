package com.packt.chaptersix.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.packt.chaptersix.data.CatsAPI
import com.packt.chaptersix.data.PetsRepository
import com.packt.chaptersix.data.PetsRepositoryImpl
import com.packt.chaptersix.viewmodel.PetsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.koin.dsl.module
import retrofit2.Retrofit

val appModules = module {
    single<PetsRepository> { PetsRepositoryImpl(get(), get()) }
    single { Dispatchers.IO }
    single { PetsViewModel(get()) }
    single {
        Retrofit.Builder()
            .addConverterFactory(
                Json.asConverterFactory(contentType = "application/json".toMediaType())
            )
            .baseUrl("https://cataas.com/api/")
            .build()
    }
    single { get<Retrofit>().create(CatsAPI::class.java) }
}