package br.com.devairon.mybankdigital.domain.auth

import br.com.devairon.mybankdigital.data.repository.auth.AuthFirebaseDataSourceImpl

class RecoverUseCase(private val authFirebaseDataSourceImpl: AuthFirebaseDataSourceImpl) {

    suspend operator fun invoke(email: String){
        return authFirebaseDataSourceImpl.recover(email)
    }
}