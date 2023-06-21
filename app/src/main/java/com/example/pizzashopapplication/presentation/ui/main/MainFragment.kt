package com.example.pizzashopapplication.presentation.ui.main

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizzashopapplication.R
import com.example.pizzashopapplication.data.ApiService
import com.example.pizzashopapplication.data.DishMapper
import com.example.pizzashopapplication.data.RepositoryImpl
import com.example.pizzashopapplication.databinding.FragmentMainBinding
import com.example.pizzashopapplication.domain.GetDishesUseCase
import com.example.pizzashopapplication.domain.Repository
import com.example.pizzashopapplication.presentation.PizzaApplication
import com.example.pizzashopapplication.presentation.ui.adapter.BannerAdapter
import com.example.pizzashopapplication.presentation.ui.adapter.MenuAdapter
import com.google.android.material.chip.Chip
import javax.inject.Inject

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentMainBinding == null")
    private lateinit var menuAdapter: MenuAdapter
    private lateinit var bannerAdapter: BannerAdapter

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory


    private val component by lazy {
        (requireActivity().application as PizzaApplication).component
    }

    private val viewModel by lazy {
        ViewModelProvider(
            this@MainFragment,
            viewModelFactory
        )[MainViewModel::class.java]
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        component.inject(this@MainFragment)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        setupChip()
    }

    private fun createChip(teg: String) {
        val chip = Chip(requireContext())
        chip.text = teg

        chip.isClickable = true
        chip.isCheckable = true
        binding.chipGroup.addView(chip)
    }

    private fun setupChip() {
        viewModel.dishesList.observe(viewLifecycleOwner) {
            val arrayList = arrayListOf<String>()
            for (i in it) {
                for (j in i.tegs) {
                    if (!arrayList.contains(j)) {
                        arrayList.add(j)
                        createChip(j)
                    }
                }
            }
        }
    }

    private fun setupRecycler() {
        menuAdapter = MenuAdapter()
        binding.recyclerMenu.adapter = menuAdapter
        bannerAdapter = BannerAdapter()
        binding.bannerRecycler.adapter = bannerAdapter

        viewModel.dishesList.observe(viewLifecycleOwner) {
            menuAdapter.submitList(it)
        }


        val bannerList = mutableListOf<Int>()
        for (i in 0..10) {
            bannerList.add(i)
        }

        binding.recyclerMenu.layoutManager = LinearLayoutManager(requireActivity())

        bannerAdapter.submitList(bannerList)
        binding.bannerRecycler.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
    }

    companion object {
        private const val MAIN_SCREEN_KEY = "MAIN_SCREEN_KEY"
        fun newInstance(): MainFragment {
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