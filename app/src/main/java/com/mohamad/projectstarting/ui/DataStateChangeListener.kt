package com.mohamad.projectstarting.ui

import com.mohamad.projectstarting.util.DataState


interface DataStateChangeListener {

    fun onDataStateChange(dataState: DataState<*>?)
    fun hideSoftKeyboard()
}