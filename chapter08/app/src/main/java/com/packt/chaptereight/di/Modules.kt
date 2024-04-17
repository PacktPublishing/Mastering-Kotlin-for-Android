package com.packt.chaptereight.di

import androidx.room.Room
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.packt.chaptereight.data.CatDatabase
import com.packt.chaptereight.data.CatsAPI
import com.packt.chaptereight.data.PetsRepository
import com.packt.chaptereight.data.PetsRepositoryImpl
import com.packt.chaptereight.viewmodel.PetsViewModel
import com.packt.chaptereight.workers.PetsSyncWorker
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.workmanager.dsl.worker
import org.koin.dsl.module
import retrofit2.Retrofit

private val json = Json {
    ignoreUnknownKeys = true
    isLenient = true
}

val appModules = module {
    single<PetsRepository> { PetsRepositoryImpl(get(), get(), get()) }
    single { Dispatchers.IO }
    single { PetsViewModel(get()) }
    single {
        Retrofit.Builder()
            .addConverterFactory(
                json.asConverterFactory(contentType = "application/json".toMediaType())
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