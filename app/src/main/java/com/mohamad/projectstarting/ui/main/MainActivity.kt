package com.mohamad.projectstarting.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import com.mohamad.projectstarting.viewmodels.ViewModelProviderFactory
import com.mohamad.projectstarting.R
import com.mohamad.projectstarting.ui.BaseActivity
import com.mohamad.projectstarting.ui.main.state.MainStateEvent
import java.lang.Exception
import javax.inject.Inject

class MainActivity : BaseActivity() {
    override fun displayProgressBar(bool: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        TODO("Not yet implemented")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       ?: throw Exception("debug : invalid activity")
        viewModel.setStateEvent(
            MainStateEvent.RegisterAttemptEvent(
                "ahmadhkkhjyjc@gmail.com",
                "ahmkkjadfghjkhjmvn",
                "11221122",
                "11221122"
            )
        )

        viewModel.dataState.observe(this, Observer { authViewState ->

            println("debug : finish")
        })
    }

    override fun hideSoftKeyboard() {
        TODO("Not yet implemented")
    }
}