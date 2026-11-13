package com.davenieljessondjiwandana.assignmentweek7.soal1.data.remote

import com.davenieljessondjiwandana.assignmentweek7.soal1.data.repository.CardRepository
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

object ServiceLocator {

    private const val BASE_URL = "https://www.pokemonpricetracker.com/api/v2/"
    private const val API_KEY = "pokeprice_free_bdcc37a9a020d65161b49bba59fee4515506650cf70e631c"
    //API Key Akun 1: pokeprice_free_6861a6c9f3087ee840064c46a37c41bbfd65c0029ff2fc8f
    //API Key Akun 2: pokeprice_free_20743ef1cb03802218ce5f5adc03f5dac79081470cad1206
    //API Key Akun 3: pokeprice_free_bdcc37a9a020d65161b49bba59fee4515506650cf70e631c
    private val json = Json { ignoreUnknownKeys = true }

    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(ApiKeyInterceptor(API_KEY))
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
            })
            .build()
    }

    private val api: PokemonApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(PokemonApiService::class.java)
    }

    val cardRepository: CardRepository by lazy { CardRepository(api) }
}