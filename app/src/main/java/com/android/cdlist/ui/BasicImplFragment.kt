package com.android.cdlist.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.cdlist.data.repository.medalItem
import com.android.cdlist.data.repository.medalList
import com.android.cdlist.databinding.FragmentBasicImplBinding

class BasicImplFragment : Fragment() {

    private var _binding: FragmentBasicImplBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBasicImplBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val centralizedList = binding?.centralizedList ?: return

        val list = medalList
        var listCount = list.size

        centralizedList.setItems(list)

        binding?.btLess?.setOnClickListener {
            if (listCount > 1) {
                list.removeLast()
                listCount--
            }

            centralizedList.setItems(list)
        }

        binding?.btMore?.setOnClickListener {
            if (listCount < 6) {
                list.add(medalItem)
                listCount++
            }

            centralizedList.setItems(list)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}