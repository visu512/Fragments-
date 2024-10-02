package com.example.fragmentskotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fragmentskotlin.R
import com.example.fragmentskotlin.databinding.FragmentBlank1Binding

@Suppress("UNREACHABLE_CODE")
class BlankFragment1 : Fragment() {
    private lateinit var binding: FragmentBlank1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlank1Binding.inflate(inflater, container, false)

        binding.button.setOnClickListener {
            Toast.makeText(context, "HELLO button", Toast.LENGTH_SHORT).show()
        }
        return binding.root

    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            BlankFragment1().apply {
                arguments = Bundle().apply {

                }
            }
    }
}