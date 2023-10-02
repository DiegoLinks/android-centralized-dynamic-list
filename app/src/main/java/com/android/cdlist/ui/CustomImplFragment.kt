package com.android.cdlist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.cdlist.data.repository.levelList
import com.android.cdlist.databinding.FragmentCustomImplBinding

class CustomImplFragment : Fragment() {

    private var _binding: FragmentCustomImplBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCustomImplBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val customList = binding?.customCentralizedList ?: return
        var page = 0

        val list = levelList

        customList.setItems(list)

        binding?.btPrev?.setOnClickListener {
            if (page > 1) {
                //todo change list
                page--
            }
        }

        binding?.btNext?.setOnClickListener {
            if (page < 6) {
                //todo change list
                page++
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}