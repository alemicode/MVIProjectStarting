package com.mohamad.projectstarting.ui.main.state

import com.mohamad.projectstarting.api.GenericResponse
import com.mohamad.projectstarting.api.network_responses.LoginResponse
import com.mohamad.projectstarting.api.network_responses.RegistrationResponse

data class MainViewState(
    var genericResponse: GenericResponse? = null

) {
    data class RegistrationField(

        var registration_email: String? = null,
        var registration_username: String? = null,
        var registration_password: String? = null,
        var registration_confirm_password: String? = null
    ) {

    }
}