package com.example.emoloyeedetail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.emoloyeedetail.viewmodel.NameViewModel

class NameActivity : AppCompatActivity(){
    private val model: NameViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
        model.currentName.observe(this) {

        }
    }
}