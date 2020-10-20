package com.mohamad.projectstarting.di

import androidx.lifecycle.ViewModelProvider
import com.mohamad.projectstarting.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}