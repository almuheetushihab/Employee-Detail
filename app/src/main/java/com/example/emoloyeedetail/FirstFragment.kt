package com.example.emoloyeedetail

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.emoloyeedetail.databinding.FragmentFirstBinding
import com.example.emoloyeedetail.viewmodel.EmployeeViewModel
import com.example.emoloyeedetail.viewmodel.MyViewModel
import kotlinx.coroutines.Delay

class FirstFragment : Fragment(), EmployeeAdapter.ItemClickListener {
    private lateinit var viewModel: EmployeeViewModel
//    private lateinit var nameViewModel: NameViewModel

    private val model: MyViewModel by viewModels()
    private lateinit var adapter: EmployeeAdapter

    private lateinit var binding: FragmentFirstBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = EmployeeViewModel()
        model.items.observe(viewLifecycleOwner, Observer {

            binding.employeeRecyclerView.adapter = EmployeeAdapter(it, this)
        })

//        nameViewModel = NameViewModel()

        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)

        val employeeAdapter = EmployeeAdapter(viewModel.getEmployees(), this)

        val recyclerView: RecyclerView = binding.employeeRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = employeeAdapter


        adapter = EmployeeAdapter(viewModel.getEmployees(), this)
        binding.employeeRecyclerView.adapter = adapter


    }

    override fun onItemClick(employee: Employee) {

        val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment5(employee)
        findNavController().navigate(action)

    }
}










