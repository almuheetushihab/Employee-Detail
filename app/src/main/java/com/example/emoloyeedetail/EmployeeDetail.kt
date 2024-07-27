package com.example.emoloyeedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.emoloyeedetail.databinding.EmployeeDetailBinding

class EmployeeDetail : Fragment() {
    private val args: EmployeeDetailArgs by navArgs()
    private lateinit var binding: EmployeeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = EmployeeDetailBinding.inflate(inflater, container, false)
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
            binding.email.tvKey.text = requireContext().getString(R.string.email)
            binding.email.tvValue.text = employee.email
            binding.address.tvKey.text = requireContext().getString(R.string.address)
            binding.address.tvValue.text = employee.address
            binding.jobTitle.tvKey.text = requireContext().getString(R.string.jobTitle)
            binding.jobTitle.tvValue.text = employee.jobTitle
            binding.salary.tvKey.text = requireContext().getString(R.string.salary)
            binding.salary.tvValue.text = employee.salary
            binding.division.tvKey.text = requireContext().getString(R.string.division)
            binding.division.tvValue.text = employee.divisions

        }
    }

}

