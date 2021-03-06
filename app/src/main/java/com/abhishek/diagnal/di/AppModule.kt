package com.abhishek.diagnal.di

import android.content.Context
import com.abhishek.diagnal.data.MovieRepository
import com.abhishek.diagnal.data.MovieRepositoryImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory()).build()
    }

    @Provides
    @Singleton
    fun providesMovieRepository(moshi: Moshi, @ApplicationContext context: Context): MovieRepository {
        return MovieRepositoryImpl(moshi, context);
    }
    

}