package com.example.fragment_practice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.Toolbar

class BFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val router = App.INSTANCE.router

        val toolbar: Toolbar = view.findViewById(R.id.toolbar_b)
        toolbar.setNavigationOnClickListener {
            router.exit()
        }

        val button: TextView = view.findViewById(R.id.button_b)
        button.setOnClickListener {
            router.navigateTo(Screens.cScreen(TEXT))
        }

        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    router.exit()
                }
            })
    }

    companion object {
        const val TEXT = "Hello Fragment C"
    }
}