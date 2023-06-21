package com.example.pizzashopapplication.di.modules

import androidx.lifecycle.ViewModel
import com.example.pizzashopapplication.di.ViewModelKey
import com.example.pizzashopapplication.presentation.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}