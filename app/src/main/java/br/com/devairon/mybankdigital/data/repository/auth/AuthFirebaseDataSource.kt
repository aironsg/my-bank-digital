package br.com.devairon.mybankdigital.data.repository.auth

interface AuthFirebaseDataSource {
    suspend fun login(email:String, password:String)
    suspend fun register(name:String, email:String, phoneNumber:String ,password:String)
    suspend fun recover(email:String)
}