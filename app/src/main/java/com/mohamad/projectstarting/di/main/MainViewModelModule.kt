package com.mohamad.projectstarting.di.main

import androidx.lifecycle.ViewModel
import com.mohamad.projectstarting.di.ViewModelKey
import com.mohamad.projectstarting.ui.main.MainViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindAccountViewModel(mainViewModel: MainViewModel): ViewModel


}