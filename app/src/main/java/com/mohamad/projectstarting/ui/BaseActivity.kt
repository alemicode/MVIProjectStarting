package com.mohamad.projectstarting.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import com.mohamad.projectstarting.session.SessionManager
import com.mohamad.projectstarting.ui.main.MainViewModel

import com.mohamad.projectstarting.util.DataState
import com.mohamad.projectstarting.util.LastApiReponseResult
import com.mohamad.projectstarting.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity(), DataStateChangeListener {


    private val debug = "App Debug"
    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        viewModel = this?.run {
            ViewModelProvider(this, providerFactory).get(viewModel::class.java)
        } ?: throw Exception("activity is not ailve")
    }
    @Inject
    lateinit var sessionManager: SessionManager
    /*
    * calling this interface just after getting response from dataState Observer
    * to handle specific state (loading, getting data, display error...)
    *
    * */
    override fun onDataStateChange(dataState: DataState<*>?) {

        dataState.let { dataState ->

            GlobalScope.launch(Main) {

                displayProgressBar(dataState?.loading!!.isLoading)

                dataState.error.let { errorEvent ->

                    handleStateError(errorEvent)

                }

                dataState.data.let { data ->

                    data?.response.let { responseEvent ->

                        handleStateResponse(responseEvent)

                    }
                }


            }
        }

    }


    private fun handleStateResponse(event: Event<Response>?) {

        event?.getContentIfNotHandled().let {

            when (it?.responseType) {

                is ResponseType.Toast -> {

                    it.message?.let {

                        displayToast(it)
                    }
                }

                is ResponseType.Dialog -> {

                    it.message.let {
                        displayErrorDialog(it)
                    }
                }

                is ResponseType.None -> {

                    println("debug : no response")
                }

                else -> println("debug : no response")

            }

            //notify state of state into subclasses


        }

    }


    private fun handleStateError(errorEvent: Event<StateError>?) {

        errorEvent?.getContentIfNotHandled().let {


            when (it?.response?.responseType) {


                is ResponseType.Toast -> {

                    it.response.message?.let {

                        displayToast(it)
                    }
                }

                is ResponseType.Dialog -> {

                    it.response.message.let {
                        displayErrorDialog(it)
                    }
                }

                is ResponseType.None -> {

                    println("debug : no response")
                }

                else -> println("debug : no response")

            }


        }

    }

    /*
    * notyfy other subclasses like fragments that their responses are fail or success
    * type = 0 No Error
    * type = 1 Error
    * */
    fun notifyStateTypeToSubClasses(type: Int, message: String): LastApiReponseResult {
        return LastApiReponseResult(
            message,
            type
        )
    }

    abstract fun displayProgressBar(bool: Boolean)
    abstract fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    )
}