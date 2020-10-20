package com.mohamad.projectstarting.di


import android.app.Application;
import android.content.Context
import android.content.SharedPreferences

import androidx.room.Room;
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.powerfulljetpack.util.Constans
import com.example.powerfulljetpack.util.LiveDataCallAdapterFactory

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mohamad.projectstarting.util.PreferenceKeys

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule {


    @Singleton
    @Provides
    fun gettingSharedPrefrences(application: Application): SharedPreferences {

        return application.getSharedPreferences(
            PreferenceKeys.APP_PREFERENCES,
            Context.MODE_PRIVATE
        )
    }


    //refrence of sharedPrefrences Editor
    @Singleton
    @Provides
    fun gettingSharedPrefrencesEditor(sharedPreferences: SharedPreferences): SharedPreferences.Editor {

        return sharedPreferences.edit()
    }

    //refrence of gson
    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {

        //excludeFieldsWithoutExposeAnnotation means if a field doesn't have @Expose Retrofit will reject to write new data on it
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    //serring up retrofit
    @Singleton
    @Provides

    fun provideRetrofitBuilder(gson: Gson): Retrofit.Builder {

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .baseUrl(Constans.BASE_URL)

    }


}