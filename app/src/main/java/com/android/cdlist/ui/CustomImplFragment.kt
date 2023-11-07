package com.android.cdlist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.cdlist.data.repository.dropList
import com.android.cdlist.data.repository.levelList
import com.android.cdlist.data.repository.trophyList
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

        var page = 0

        showList(page)

        binding?.btPrev?.setOnClickListener {
            if (page > 0) {
                page--
                showList(page = page)
            }
        }

        binding?.btNext?.setOnClickListener {
            if (page < 3) {
                page++
                showList(page = page)
            }
        }
    }

    private fun showList(page: Int) {
        val customList = binding?.customCentralizedList ?: return

        val level = levelList
        val trophy = trophyList
        val drop = dropList

        when (page) {
            0 -> {
                customList.setItemsWithCoilBlackAndWithe(level)
            }

            1 -> {
                customList.setItemsWithGlideBlackAndWithe(trophy)
            }

            2 -> {
                customList.setItemsWithGlideBlur(trophy)
            }

            3 -> {
                customList.setItemsWithGlideBlackAndWithe(drop)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}