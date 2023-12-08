package br.com.devairon.mybankdigital.presenter.auth.recover

import androidx.lifecycle.liveData
import br.com.devairon.mybankdigital.domain.auth.RecoverUseCase
import br.com.devairon.mybankdigital.utils.StateView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class RecoverViewModel @Inject constructor(
   private val recoverUseCase: RecoverUseCase
) {
    fun recover(email: String) = liveData(Dispatchers.IO) {
        try {
            emit(StateView.Loading())
            recoverUseCase.invoke(email)
            emit(StateView.Success(null))
        }catch (ex:Exception){
            emit(StateView.Error(ex.message))
        }
    }

}