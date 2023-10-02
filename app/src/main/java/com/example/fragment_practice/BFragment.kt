package com.example.fragment_practice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.fragment.app.commit

class BFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar: Toolbar = view.findViewById(R.id.toolbar_b)
        toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        val button: TextView = view.findViewById(R.id.button_b)
        button.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, getFragmentC())
                    .addToBackStack(null)
                    .setReorderingAllowed(true)
            }
        }

    }

    private fun getFragmentC() = CFragment().apply {
        arguments = bundleOf(TEXT to "Hello Fragment C")
    }

    companion object {
        const val TEXT = "TEXT"
    }
}