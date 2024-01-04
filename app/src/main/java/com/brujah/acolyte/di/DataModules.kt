package com.brujah.acolyte.di

import com.brujah.acolyte.data.source.network.SpellsApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


private const val BASE_URL = "https://wizard-world-api.herokuapp.com"

@Module
@InstallIn(SingletonComponent::class)
class NetworkingModule {
    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            // .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun providesSpellsService(retrofit: Retrofit): SpellsApiService {
        return retrofit.create(SpellsApiService::class.java)
    }
}
