package com.example.emoloyeedetail

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.emoloyeedetail.databinding.ActivityEmployeeDivisionsBinding

class EmployeeDivisionsActivity : AppCompatActivity(), DivisionAdapter.ItemClickListener {
//    private val viewModel: EmployeeViewModel by viewModels()
    private lateinit var binding: ActivityEmployeeDivisionsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEmployeeDivisionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val divisionAdapter = DivisionAdapter(dataset, this)


        val recyclerView: RecyclerView = findViewById(R.id.division_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = divisionAdapter

        enableEdgeToEdge()
        setContentView(R.layout.activity_employee_divisions)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

    }

    override fun onItemClick(employee: Employee) {

    }


}