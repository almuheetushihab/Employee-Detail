package com.example.emoloyeedetail.viewmodel

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NameViewModel: ViewModel() {
    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun setName(newName: String) {
        currentName.value = newName


        val handler = Handler()
        handler.postDelayed({
            currentName.value = "Johny Doe"
        }, 2000)
    }
}