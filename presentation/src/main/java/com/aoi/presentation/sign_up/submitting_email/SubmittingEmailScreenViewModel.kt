package com.aoi.presentation.sign_up.submitting_email

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SubmittingEmailScreenViewModel: ViewModel() {
    private val _state = MutableStateFlow(SubmittingEmailScreenState(
        email = "",
        onEmailChange = { email -> setEmail(email)},
        onNavigateVerifyingEmailScreen = {},
        onNavigateToSignInScreen = {})
    )
    val state = _state.asStateFlow()

    fun setClickEventOnNavigateToSignInButton(navigateEvent: () -> Unit) {
        _state.update {
            it.copy(
                onNavigateVerifyingEmailScreen = {
                    sendAuthTokenToEmail(
                        onSuccessProc = navigateEvent,
                        onFailureProc = { }
                    )
                }
            )
        }
    }

    fun setClickEventOnNavigateToVerifyEmailButton(navigateEvent: () -> Unit) {
        _state.update { it.copy(onNavigateToSignInScreen = navigateEvent) }
    }

    private fun setEmail(email: String) {
        _state.update {
            it.copy(
                email = email,
                isEmailValid = checkEmailValidation(email),
                emailErrorMessage = getEmailErrorMessageResourceId(checkEmailValidation(email))
            )
        }
    }

    private fun sendAuthTokenToEmail(onSuccessProc: () -> Unit, onFailureProc: () -> Unit) {
        //TODO: 認証メール送信機能作成
        val email = _state.value.email
    }

    private fun checkEmailValidation(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun getEmailErrorMessageResourceId(isEmailValid: Boolean): Int? {
        return if(isEmailValid){
            null
        } else {
            com.aoi.core.R.string.sign_up_error_message_invalid_email
        }
    }
}