package com.example.fragment_practice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.commit

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
        text.text = requireArguments().getString(BFragment.TEXT)

        val button: TextView = view.findViewById(R.id.button_c)
        button.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, DFragment())
                addToBackStack(null)
                setReorderingAllowed(true)
            }
        }
    }
}