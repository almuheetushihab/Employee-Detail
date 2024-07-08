package com.example.emoloyeedetail

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.emoloyeedetail.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)

//        val employee = when {
//
//            Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> arguments?.getSerializable(
//                "employee",
//                Employee::class.java
//            )
//
//            else -> @Suppress("DEPRECATION") arguments?.getSerializable("employee") as? Employee
//        }

val employee = arguments?.getSerializable("employee") as? Employee

        employee?.let {
            Glide.with(requireContext())
                .load(employee.image)
                .circleCrop()
                .into(binding.ivEmployeeImgId)

            binding.tvEmployeeName.text = employee.name
            binding.tvEmployeePhone.text = employee.phone
            binding.tvEmployeeEmail.text = employee.email
            binding.tvEmployeeAddress.text = employee.address
            binding.tvEmployeeJobTitle.text = employee.jobTitle
            binding.tvEmployeeSalary.text = employee.salary

        }

    }

}