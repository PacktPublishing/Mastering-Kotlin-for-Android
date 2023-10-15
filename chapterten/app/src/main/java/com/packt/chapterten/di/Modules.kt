package com.packt.chapterten.di

import androidx.room.Room
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.packt.chapterten.data.CatDatabase
import com.packt.chapterten.data.CatsAPI
import com.packt.chapterten.data.PetsRepository
import com.packt.chapterten.data.PetsRepositoryImpl
import com.packt.chapterten.viewmodel.PetsViewModel
import com.packt.chapterten.workers.PetsSyncWorker
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.workmanager.dsl.worker
import org.koin.dsl.module
import retrofit2.Retrofit

val appModules = module {
    single<PetsRepository> { PetsRepositoryImpl(get(), get(), get()) }
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

    single {
        Room.databaseBuilder(
            androidContext(),
            CatDatabase::class.java,
            "cat-database"
        ).build()
    }
    single { get<CatDatabase>().carDao() }
    worker { PetsSyncWorker(get(), get(), get()) }

}