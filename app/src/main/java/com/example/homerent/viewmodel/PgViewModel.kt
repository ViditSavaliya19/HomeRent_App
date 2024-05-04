package com.example.homerent.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homerent.model.PGModel
import com.example.homerent.repository.PGRepository.Companion.repo
import kotlinx.coroutines.launch

class PgViewModel(val context: Context) : ViewModel() {
    private var _pgList = MutableLiveData<List<PGModel>>()
    val pgList: MutableLiveData<List<PGModel>>
        get() = _pgList

    init {
        viewModelScope.launch {
            getPGList()
        }
    }

    private suspend fun getPGList() {
        try {
            _pgList.value = repo.getPGListAPICall()
        }
        catch (e : Exception)
        {
            Toast.makeText(context, "${e.message}", Toast.LENGTH_SHORT).show()
        }

    }

}