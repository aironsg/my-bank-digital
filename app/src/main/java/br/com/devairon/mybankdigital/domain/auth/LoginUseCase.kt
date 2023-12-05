package br.com.devairon.mybankdigital.domain.auth

import br.com.devairon.mybankdigital.data.repository.auth.AuthFirebaseDataSourceImpl

class LoginUseCase(private val authFirebaseDataSourceImpl: AuthFirebaseDataSourceImpl) {

    suspend operator fun invoke(email: String, password: String) {
        return authFirebaseDataSourceImpl.login(email, password)
    }
}