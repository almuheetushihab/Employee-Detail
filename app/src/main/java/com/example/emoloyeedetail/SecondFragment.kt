package com.example.emoloyeedetail

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.emoloyeedetail.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val employee = when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> arguments?.getSerializable("employee", Employee::class.java)
            else -> @Suppress("DEPRECATION") arguments?.getSerializable("employee") as? Employee
        }

        employee?.let {
            Glide.with(requireContext())
                .load(employee.image)
                .into(binding.ivEmployeeImg)

            binding.tvEmployeeName.text = employee.name
            binding.tvEmployeePhone.text = employee.phone
            binding.tvEmployeeEmail.text = employee.email
            binding.tvEmployeeAddress.text = employee.address
            binding.tvEmployeeJobTitle.text = employee.jobTitle
            binding.tvEmployeeSalary.text = employee.salary

        }

//        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}