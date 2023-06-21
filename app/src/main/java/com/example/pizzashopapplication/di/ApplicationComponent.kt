package com.example.pizzashopapplication.di

import android.app.Application
import com.example.pizzashopapplication.di.modules.DataModule
import com.example.pizzashopapplication.di.modules.NetworkModule
import com.example.pizzashopapplication.di.modules.ViewModelModule
import com.example.pizzashopapplication.presentation.ui.main.MainFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, NetworkModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(fragment: MainFragment)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}