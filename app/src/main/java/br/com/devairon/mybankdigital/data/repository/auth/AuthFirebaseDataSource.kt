package br.com.devairon.mybankdigital.data.repository.auth

import br.com.devairon.mybankdigital.data.model.User
import com.google.firebase.auth.FirebaseUser

interface AuthFirebaseDataSource {
    suspend fun login(email:String, password:String)
    suspend fun register(user: User) : User
    suspend fun recover(email:String)
}