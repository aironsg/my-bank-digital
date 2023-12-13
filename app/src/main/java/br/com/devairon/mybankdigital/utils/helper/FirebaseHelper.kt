package br.com.devairon.mybankdigital.utils.helper

import com.google.firebase.auth.FirebaseAuth

class FirebaseHelper {
    companion object{
        fun isAuthenticated() =  FirebaseAuth.getInstance().currentUser != null
    }
}