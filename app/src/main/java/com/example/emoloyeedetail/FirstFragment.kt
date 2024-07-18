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
import androidx.transition.Visibility
import com.example.emoloyeedetail.databinding.FragmentFirstBinding
import com.example.emoloyeedetail.viewmodel.EmployeeViewModel

import kotlinx.coroutines.Delay

class FirstFragment : Fragment(), EmployeeAdapter.ItemClickListener {
    private val viewModel: EmployeeViewModel by viewModels()
    private lateinit var adapter: EmployeeAdapter
    private lateinit var binding: FragmentFirstBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = binding.employeeRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.getItems()
        viewModel.items.observe(viewLifecycleOwner, Observer {
            adapter = EmployeeAdapter(it, this)
            recyclerView.adapter = adapter
            binding.loadingId.root.visibility = View.GONE
            binding.employeeRecyclerView.visibility = View.VISIBLE
        })

    }

    override fun onItemClick(employee: Employee) {

        val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment5(employee)
        findNavController().navigate(action)

    }
}










