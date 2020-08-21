package com.schaefer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment(
    @LayoutRes private val layoutId: Int
) : Fragment(layoutId) {

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(savedInstanceState)
        setupListeners()
        setupObservers()
    }

    open fun setupObservers() {}

    protected open fun setupListeners() {}

    protected open fun setupView(savedInstanceState: Bundle?) {}
}