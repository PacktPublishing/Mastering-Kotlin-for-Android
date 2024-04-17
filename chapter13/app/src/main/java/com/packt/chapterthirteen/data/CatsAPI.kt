package com.packt.chapterthirteen.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CatsAPI {
    @GET("cats")
    suspend fun fetchCats(
        @Query("tag") tag: String
    ): Response<List<Cat>>
}