package com.android.cdlist.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.cdlist.R
import com.android.cdlist.component.HorizontalCentralizedList
import com.android.cdlist.data.repository.getCardData
import com.android.cdlist.data.repository.medalList
import com.android.cdlist.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.centralizedList.setItems(medalList)

        val context = activity ?: return

        val adapter = DescriptionAdapter(getCardData(context)) {
            val route = it.id
            navigate(route = route)
        }
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun navigate(route: Int) {
        if (route == 0) {
            findNavController().navigate(R.id.action_HomeFragment_to_BasicImplementationFragment)
        }
    }
}