package br.com.devairon.mybankdigital.data.repository.auth

class AuthFirebaseDataSourceImpl() : AuthFirebaseDataSource {

    override suspend fun login(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun register(
        name: String, email: String, phoneNumber: String, password: String
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun recover(email: String) {
        TODO("Not yet implemented")
    }


}