package com.example.pizzashopapplication.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pizzashopapplication.R
import com.example.pizzashopapplication.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentMainBinding == null")



    private  val viewModel by lazy {
        ViewModelProvider(this@MainFragment)[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }



    companion object {
        const val MAIN_SCREEN_KEY = "MAIN_SCREEN_KEY"
        fun newInstance() : MainFragment {
            return MainFragment().apply {
                arguments = Bundle().apply {
                    putString(MAIN_SCREEN_KEY, "value")
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }

}