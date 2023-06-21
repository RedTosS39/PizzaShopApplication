package com.example.pizzashopapplication.presentation

import android.app.Application
import com.example.pizzashopapplication.di.DaggerApplicationComponent

class PizzaApplication : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}