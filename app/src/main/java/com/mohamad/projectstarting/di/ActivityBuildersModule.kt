package com.mohamad.projectstarting.di



import com.example.powerfulljetpack.di.main.MainScope

import com.mohamad.projectstarting.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {
    

    @MainScope
    @ContributesAndroidInjector(

        
    )
    abstract fun contributeMainActivity(): MainActivity

}