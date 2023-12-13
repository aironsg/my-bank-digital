package br.com.devairon.mybankdigital.domain.auth

import android.util.Log
import br.com.devairon.mybankdigital.data.model.User
import br.com.devairon.mybankdigital.data.repository.auth.AuthFirebaseDataSourceImpl
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val authFirebaseDataSourceImpl: AuthFirebaseDataSourceImpl) {

    suspend operator fun invoke(user: User): User {
        return authFirebaseDataSourceImpl.register(user)
    }
}