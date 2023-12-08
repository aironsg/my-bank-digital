package br.com.devairon.mybankdigital.presenter.auth.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import br.com.devairon.mybankdigital.data.model.User
import br.com.devairon.mybankdigital.domain.auth.LoginUseCase
import br.com.devairon.mybankdigital.utils.StateView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
   private val loginUseCase: LoginUseCase
) {

    fun login(email: String, password:String) = liveData(Dispatchers.IO){

        try {
            emit(StateView.Loading())
            loginUseCase.invoke(email,password)
            emit(StateView.Success(null))
        }catch (ex: Exception){
            emit(StateView.Error(ex.message))
        }
    }

}