package com.example.emoloyeedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.emoloyeedetail.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private val args: SecondFragmentArgs by navArgs()
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

        val employee = args.data
        employee.let {
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
            binding.tvEmployeeDivision.text = employee.divisions

        }
    }
}