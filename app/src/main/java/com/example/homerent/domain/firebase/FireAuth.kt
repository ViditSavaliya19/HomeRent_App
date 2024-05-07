package com.example.homerent.domain.firebase

import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.tasks.await
import kotlin.math.log

class FireAuth {
    var firebaseAuth: FirebaseAuth = Firebase.auth

    companion object {
        val fireAuth = FireAuth()
    }


    suspend fun signUp(email: String, password: String): Boolean {
        try {
            var res = firebaseAuth.createUserWithEmailAndPassword(email, password).await()

            return res.user != null
        } catch (e: Exception) {
            Log.e("TAG", "signUp: $e")
            return false
        }
    }

    suspend fun signIn(email: String, password: String): Boolean {
        try {
            val res = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            return res.user != null

        } catch (e: Exception) {
            Log.e("TAG", "signIn: $e")
            return false
        }

    }


}