package com.example.emoloyeedetail

import java.io.Serializable

data class Employee(
    val name: String,
    val phone: String,
    val image: String,
    val email: String,
    val address: String,
    val jobTitle: String,
    val salary: String
) :Serializable
