package com.example.learn.di


import com.example.learn.APIservice.CompetitionApi
import com.example.learn.Constans.Cons.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getRetroFitServiceInstance(retrofit: Retrofit):CompetitionApi{
        return retrofit.create(CompetitionApi::class.java)
    }

    @Singleton
    @Provides
    fun getRetroFitInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}