package com.example.homerent.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homerent.domain.firebase.FireAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class AuthViewModel(mainActivity: Context) : ViewModel() {

    var user: FirebaseUser? = null

    init {
        currentUser()
    }


    fun currentUser() {
        user = FireAuth.fireAuth.firebaseAuth.currentUser

    }


    suspend fun login(email: String, password: String): Boolean {
        return FireAuth.fireAuth.signIn(email, password)
    }

    suspend fun registration(email: String, password: String): Boolean {
        return FireAuth.fireAuth.signUp(email, password)
    }


    fun logout() {
        FireAuth.fireAuth.firebaseAuth.signOut()
        currentUser()
    }


}