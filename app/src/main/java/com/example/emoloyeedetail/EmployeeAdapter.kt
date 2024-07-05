import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.emoloyeedetail.Employee
import com.example.emoloyeedetail.FirstFragment
import com.example.emoloyeedetail.R

class EmployeeAdapter(
    private val dataset: ArrayList<Employee>,
    private val listener: FirstFragment,
) : RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {
    interface ItemClickListener {
        fun onItemClick(employee: Employee)
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val employeeName : TextView
        val employeeNum : TextView
        val employeeImg : ImageView
        init {
            employeeName = view.findViewById(R.id.tv_employee_name)
            employeeNum = view.findViewById(R.id.iv_employee_num)
            employeeImg = view.findViewById(R.id.iv_employee_img)
        }
//        val textView: TextView = view.findViewById(R.id.tv_employee_name)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.employee_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
        ) {
        val employee = dataset[position]
        Glide.with(holder.itemView.context)
            .load(employee.image)
            .into(holder.employeeImg)


        holder.employeeName.text = employee.name
        holder.employeeNum.text = employee.phone

        holder.itemView.setOnClickListener {
            listener.onItemClick(employee)
        }

    }


}