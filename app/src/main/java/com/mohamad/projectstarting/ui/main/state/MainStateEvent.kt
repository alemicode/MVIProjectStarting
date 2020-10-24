package com.mohamad.projectstarting.ui.main.state

sealed class MainStateEvent {

    data class RegisterAttemptEvent(
        val email: String,
        val username: String,
        val password: String,
        val confirmPassword: String

    ) : MainStateEvent()

}