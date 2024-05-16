package com.example.homerent.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homerent.domain.firebase.FireAuth
import com.example.homerent.model.UserModel
import com.example.homerent.repository.PGRepository
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class AuthViewModel(val context: Context) : ViewModel() {

    var user: FirebaseUser? = null
    private var _userDataList = MutableLiveData<List<UserModel>?>()
    val userDataList: MutableLiveData<List<UserModel>?>
        get() = _userDataList

    init {
        viewModelScope.launch {
            currentUser()
        }
    }


    suspend fun currentUser() {
        user = FireAuth.fireAuth.firebaseAuth.currentUser
        getUserInfo()
    }


    suspend fun login(email: String, password: String): Boolean {
        return FireAuth.fireAuth.signIn(email, password)
    }

    suspend fun registration(email: String, password: String): Boolean {
        return FireAuth.fireAuth.signUp(email, password)
    }


    fun logout() {
        FireAuth.fireAuth.firebaseAuth.signOut()
        viewModelScope.launch {
            currentUser()
        }
    }

    private suspend fun getUserInfo() {
        try {
            var data = PGRepository.repo.getUserInfoAPICall(user!!.uid)
            if(data.isNotEmpty())
            {
                _userDataList.value = data
            }
            Log.e("TAG", "getUserInfo: ${_userDataList}", )
        } catch (e: Exception) {
            Log.e("TAG", "UserDetails: ${e.message}")
            Toast.makeText(context, "${e.message}", Toast.LENGTH_SHORT).show()
        }

    }


}