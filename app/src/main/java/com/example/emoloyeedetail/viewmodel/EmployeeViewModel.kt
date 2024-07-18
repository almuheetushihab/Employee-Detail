package com.example.emoloyeedetail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.emoloyeedetail.Employee
import com.example.emoloyeedetail.dataset

class EmployeeViewModel {
    fun getEmployees(): ArrayList<Employee>{
        return dataset


    }
}