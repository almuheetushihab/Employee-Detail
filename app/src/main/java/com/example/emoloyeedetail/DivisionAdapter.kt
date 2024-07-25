package com.example.emoloyeedetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.emoloyeedetail.EmployeeAdapter.ItemClickListener


class DivisionAdapter(
    private var dataset: ArrayList<Employee>,
    private val listener: ItemClickListener,
) :
    RecyclerView.Adapter<DivisionAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val employeeDivisions: TextView

        init {
            employeeDivisions = view.findViewById(R.id.tv_employee_division)
        }
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view =
            LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.division_layout, viewGroup, false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(
        viewHolder: ViewHolder,
        position: Int
    ) {
        val employee = dataset[position]

        viewHolder.employeeDivisions.text = employee.divisions

        viewHolder.itemView.setOnClickListener {
            listener.onItemClick(employee)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    interface ItemClickListener {
        fun onItemClick(employee: Employee)
    }
}
