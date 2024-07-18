package com.example.emoloyeedetail.viewmodel

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.emoloyeedetail.Employee
import com.example.emoloyeedetail.dataset

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



//class MyViewModel: ViewModel() {
//    private val _items = MutableLiveData<ArrayList<Employee>>()
//    val items: LiveData<ArrayList<Employee>> get() = _items
//
//    fun setItems() {
//        _items.value = dataset
//
//        val handler = Handler()
//        handler.postDelayed({
//
//            _items.value = dataset
//
//        }, 2000)
//    }
//}