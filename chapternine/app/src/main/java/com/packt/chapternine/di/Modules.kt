package com.packt.chapternine.di

import androidx.room.Room
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.packt.chapternine.data.CatDatabase
import com.packt.chapternine.data.CatsAPI
import com.packt.chapternine.data.PetsRepository
import com.packt.chapternine.data.PetsRepositoryImpl
import com.packt.chapternine.viewmodel.PetsViewModel
import com.packt.chapternine.workers.PetsSyncWorker
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.workmanager.dsl.worker
import org.koin.dsl.module
import retrofit2.Retrofit
@OptIn(ExperimentalSerializationApi::class)
private val json = Json {
    ignoreUnknownKeys = true
    isLenient = true
    explicitNulls = false
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