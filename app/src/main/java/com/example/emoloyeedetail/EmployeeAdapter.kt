import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.emoloyeedetail.Employee
import com.example.emoloyeedetail.FirstFragment
import com.example.emoloyeedetail.R

class EmployeeAdapter(
    private val dataset: ArrayList<Employee>,
    private val listener: ItemClickListener

) :
    RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val employeeName: TextView
        val employeeNum: TextView
        val employeeImg: ImageView


        init {
            employeeName = view.findViewById(R.id.tv_employee_name)
            employeeNum = view.findViewById(R.id.iv_employee_num)
            employeeImg = view.findViewById(R.id.iv_employee_img)
        }
//        val textView: TextView = view.findViewById(R.id.tv_employee_name)
    }


    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        val view =
            LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.employee_layout, viewGroup, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(
        viewHolder: ViewHolder,
        position: Int,
    ) {
        val employee = dataset[position]

        Glide.with(viewHolder.employeeImg.context)
            .load(employee.image)
            .circleCrop()
            .into(viewHolder.employeeImg)

        viewHolder.itemView.contentDescription = employee.name
        viewHolder.employeeName.text = employee.name
        viewHolder.employeeNum.text = employee.phone
//        Glide.with(viewHolder.itemView.context)
//            .load(employee.image)
//            .into(viewHolder.employeeImg)


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