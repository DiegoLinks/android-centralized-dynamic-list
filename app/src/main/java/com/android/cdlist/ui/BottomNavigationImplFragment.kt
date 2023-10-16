package com.android.cdlist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.cdlist.data.repository.labelButtonList
import com.android.cdlist.data.repository.multipleButtonList
import com.android.cdlist.data.repository.simpleButtonList
import com.android.cdlist.data.repository.topLabelButtonList
import com.android.cdlist.databinding.FragmentBottomNavigationImplBinding

class BottomNavigationImplFragment : Fragment() {

    private var _binding: FragmentBottomNavigationImplBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBottomNavigationImplBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var page = 0

        showBottomNavigation(page)

        binding?.btPrev?.setOnClickListener {
            if (page > 0) {
                page--
                showBottomNavigation(page = page)
            }
        }

        binding?.btNext?.setOnClickListener {
            if (page < 3) {
                page++
                showBottomNavigation(page = page)
            }
        }
    }

    private fun showBottomNavigation(page: Int) {
        val customBottomNavigation = binding?.customBottomNavigation ?: return

        val labelButton = labelButtonList
        val topLabelButton = topLabelButtonList
        val simpleButton = simpleButtonList
        val multipleButton = multipleButtonList

        when (page) {
            0 -> {
                customBottomNavigation.setButtons(labelButton)
            }

            1 -> {
                customBottomNavigation.setButtons(topLabelButton)
            }

            2 -> {
                customBottomNavigation.setButtons(simpleButton)
            }

            3 -> {
                customBottomNavigation.setButtons(multipleButton)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}