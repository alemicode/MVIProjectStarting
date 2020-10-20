package com.mohamad.projectstarting.di.main


import com.mohamad.projectstarting.api.OpenApiAuthMainService
import com.mohamad.projectstarting.repository.main.MainRepository
import com.mohamad.projectstarting.session.SessionManager
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class MainModule {


    @MainScope
    @Provides
    fun provideOpenApiMainService(retrofitBuilder: Retrofit.Builder): OpenApiAuthMainService {
        return retrofitBuilder
            .build()
            .create(OpenApiAuthMainService::class.java)
    }

    @MainScope
    @Provides
    fun provideBlogRepository(
        openApiMainService: OpenApiAuthMainService,
        sessionManager: SessionManager
    ): MainRepository {
        return MainRepository(openApiMainService,sessionManager)
    }


}