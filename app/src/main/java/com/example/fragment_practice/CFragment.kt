package com.example.fragment_practice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController

class CFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_c, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text: TextView = view.findViewById(R.id.text)
        text.text = requireArguments().getString(TEXT)

        val button: TextView = view.findViewById(R.id.button_c)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_CFragment_to_DFragment)
        }
    }

    companion object {
        fun createArgs(text: String): Bundle = bundleOf(TEXT to text)
        private const val TEXT = "TEXT"
    }
}