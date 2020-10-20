package com.mohamad.projectstarting.ui.main

import androidx.lifecycle.LiveData
import com.mohamad.projectstarting.repository.main.MainRepository
import com.mohamad.projectstarting.ui.BaseViewModel
import com.mohamad.projectstarting.ui.main.state.MainStateEvent
import com.mohamad.projectstarting.ui.main.state.MainViewState
import com.mohamad.projectstarting.util.DataState
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Inject

class MainViewModel
@Inject
constructor(
    val authRepository: MainRepository

) : BaseViewModel<MainStateEvent, MainViewState>() {
    @InternalCoroutinesApi
    override fun handleStateEvent(it: MainStateEvent): LiveData<DataState<MainViewState>> {

        when (it) {
            is MainStateEvent.RegisterAttemptEvent -> {
                return authRepository.register(
                    it.email,
                    it.username,
                    it.password,
                    it.confirmPassword
                )
            }
        }
    }

    override fun initNewStateEvent(): MainViewState {

        return MainViewState()
    }


}