package com.mohamad.projectstarting.session

import android.app.Application
import android.content.ContentValues.TAG
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.annotation.Nullable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class SessionManager @Inject constructor(

    val application: Application

) {


    fun isConnectedToTheInternet(): Boolean {
        val cm = application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        try {
            return cm.activeNetworkInfo.isConnected
        } catch (e: Exception) {
            Log.e(TAG, "isConnectedToTheInternet: ${e.message}")
        }
        return false
    }


}