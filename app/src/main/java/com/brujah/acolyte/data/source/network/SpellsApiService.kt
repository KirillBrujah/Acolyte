package com.brujah.acolyte.data.source.network

import com.brujah.acolyte.data.Spell
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface SpellsApiService {
    @GET("Spells")
    suspend fun getSpells(): List<Spell>

    @GET("Spells/{id}")
    suspend fun getSpell(@Path("id") id: String): Spell
}