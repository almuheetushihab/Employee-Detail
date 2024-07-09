package com.example.emoloyeedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.emoloyeedetail.databinding.FragmentFirstBinding

class FirstFragment : Fragment(), EmployeeAdapter.ItemClickListener {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)

        val employeeAdapter = EmployeeAdapter(dataset, this)

        val recyclerView: RecyclerView = binding.employeeRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = employeeAdapter

    }

    override fun onItemClick(employee: Employee) {

        val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment5(employee)
        findNavController().navigate(action)


//        val bundle = bundleOf()
//
//        bundle.putSerializable("employee", employee)
//        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)



    }
}










