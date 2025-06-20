package com.misc.home_data.di

import com.misc.home_data.remote.BeerApi
import com.misc.home_data.repository.HomeRepositoryImpl
import com.misc.home_domain.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeDataModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).build()
    }

    @Provides
    @Singleton
    fun provideBeerApi(client: OkHttpClient): BeerApi {
        return Retrofit.Builder().baseUrl(BeerApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(client).build().create()
    }

    @Provides
    @Singleton
    fun provideBeerListRepository(api: BeerApi): HomeRepository {
        return HomeRepositoryImpl(
            api = api
        )
    }
}