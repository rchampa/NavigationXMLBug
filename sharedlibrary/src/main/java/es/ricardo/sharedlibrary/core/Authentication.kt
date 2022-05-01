package es.ricardo.sharedlibrary.core

import android.content.Context
import androidx.fragment.app.FragmentActivity

public sealed class LoginState {
    data class Success(val token: String): LoginState()
    object InvalidCredentials: LoginState()
    object UnknownError: LoginState()
}

interface Authentication {
    fun init(context: Context)
    fun webAuth(fragmentActivity: FragmentActivity, callback: (LoginState) -> Unit)
    fun signOut()
    companion object {
        fun build(): Authentication {
            return AuthenticationImp()
        }
    }
}