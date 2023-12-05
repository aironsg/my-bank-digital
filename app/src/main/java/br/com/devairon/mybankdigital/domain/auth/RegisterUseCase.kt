package br.com.devairon.mybankdigital.domain.auth

import br.com.devairon.mybankdigital.data.repository.auth.AuthFirebaseDataSourceImpl

class RegisterUseCase(private val authFirebaseDataSourceImpl: AuthFirebaseDataSourceImpl) {

    suspend operator fun invoke(name: String, email: String, phoneNumber: String, password: String){
        return authFirebaseDataSourceImpl.register(name, email, phoneNumber, password)
    }
}