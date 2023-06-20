package com.example.pizzashopapplication.presentation.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizzashopapplication.data.ApiService
import com.example.pizzashopapplication.data.DishMapper
import com.example.pizzashopapplication.data.RepositoryImpl
import com.example.pizzashopapplication.databinding.FragmentMainBinding
import com.example.pizzashopapplication.domain.GetDishesUseCase
import com.example.pizzashopapplication.domain.Repository
import com.example.pizzashopapplication.presentation.ui.adapter.BannerAdapter
import com.example.pizzashopapplication.presentation.ui.adapter.MenuAdapter

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentMainBinding == null")
    private lateinit var menuAdapter: MenuAdapter
    private lateinit var bannerAdapter: BannerAdapter

    val useCase = GetDishesUseCase()
    val repository: Repository = RepositoryImpl()

    private val viewModelFactory by lazy {
        MainViewModelFactory(useCase, repository)
    }

    private val viewModel by lazy {
        ViewModelProvider(
            this@MainFragment,
            viewModelFactory
        )[MainViewModel::class.java]
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