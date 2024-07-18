package com.example.emoloyeedetail.viewmodel

import android.os.Handler
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.transition.Visibility
import com.example.emoloyeedetail.Employee
import com.example.emoloyeedetail.dataset

class EmployeeViewModel : ViewModel() {

    private val _items = MutableLiveData<ArrayList<Employee>>()
    val items: LiveData<ArrayList<Employee>> get() = _items

    fun setItems() {
        _items.value = dataset

//        val handler = Handler()
//        handler.postDelayed({
//
//            _items.value = dataset
//
//        }, 2000)
    }
}