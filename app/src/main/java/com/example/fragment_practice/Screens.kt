package com.example.fragment_practice

import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun aScreen() = FragmentScreen { AFragment() }
    fun bScreen() = FragmentScreen { BFragment() }
    fun cScreen(text: String) = FragmentScreen(text) { CFragment.newInstance(text) }
    fun dScreen() = FragmentScreen { DFragment() }
}