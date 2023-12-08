package br.com.devairon.mybankdigital.presenter.auth.register

import androidx.lifecycle.liveData
import br.com.devairon.mybankdigital.data.model.User
import br.com.devairon.mybankdigital.domain.auth.RegisterUseCase
import br.com.devairon.mybankdigital.utils.StateView
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
) {

    fun register( user: User) = liveData(Dispatchers.IO){

        try {

            emit(StateView.Loading())
            registerUseCase.invoke(user)
            emit(StateView.Success(user))

        }catch (ex : Exception){
            emit(StateView.Error(ex.message))
        }
    }
}