package com.example.fragment_practice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController

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
            findNavController().navigateUp()
        }

        val button: TextView = view.findViewById(R.id.button_b)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_BFragment_to_CFragment, CFragment.createArgs(TEXT))
        }
    }

    companion object {
        const val TEXT = "Hello Fragment C"
    }
}