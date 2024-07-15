package com.example.emoloyeedetail.viewmodel

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.emoloyeedetail.Employee

//class NameViewModel: ViewModel() {
//    val currentName: MutableLiveData<String> by lazy {
//        MutableLiveData<String>()
//    }
//
//    fun setName(newName: String) {
//        currentName.value = newName
//
//
//        val handler = Handler()
//        handler.postDelayed({
//
//            currentName.value = "Johny Doe"
//        }, 2000)
//    }
//}



class MyViewModel: ViewModel() {
    private val _items = MutableLiveData<ArrayList<String>>()
    val items: LiveData<ArrayList<String>> get() = _items

    init {
        _items.value = ArrayList()
    }

    fun addItem(item: String) {
        val updatedList = _items.value ?: ArrayList()
        updatedList.add(item)
        _items.value = updatedList
    }

    fun setItems(newItems: ArrayList<String>) {
        _items.value = newItems
    }
}