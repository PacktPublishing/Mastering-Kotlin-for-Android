package com.packt.chapterthirteen.di

import androidx.room.Room
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.packt.chapterthirteen.data.CatDatabase
import com.packt.chapterthirteen.data.CatsAPI
import com.packt.chapterthirteen.data.PetsRepository
import com.packt.chapterthirteen.data.PetsRepositoryImpl
import com.packt.chapterthirteen.viewmodel.PetsViewModel
import com.packt.chapterthirteen.workers.PetsSyncWorker
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
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
        val chuckerCollector = ChuckerCollector(
            context = androidContext(),
            showNotification = true,
            retentionPeriod = RetentionManager.Period.ONE_HOUR
        )

        val chuckerInterceptor = ChuckerInterceptor.Builder(androidContext())
            .collector(chuckerCollector)
            .maxContentLength(250000L)
            .redactHeaders(emptySet())
            .alwaysReadResponseBody(false)
            .build()

        OkHttpClient.Builder()
            .addInterceptor(chuckerInterceptor)
            .build()
    }
    single {
        Retrofit.Builder()
            .addConverterFactory(
                json.asConverterFactory(
                    contentType = "application/json".toMediaType()
                )
            )
            .client(get())
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