package com.mohamad.projectstarting.di


import com.mohamad.projectstarting.di.main.MainScope
import com.mohamad.projectstarting.di.main.MainViewModelModule
import com.mohamad.projectstarting.di.main.MainModule

import com.mohamad.projectstarting.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {


    @MainScope
    @ContributesAndroidInjector(

        modules = [MainModule::class, MainViewModelModule::class]
    )
    abstract fun contributeMainActivity(): MainActivity

}