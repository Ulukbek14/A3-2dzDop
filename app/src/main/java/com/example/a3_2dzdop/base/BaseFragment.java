package com.example.a3_2dzdop.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import org.jetbrains.annotations.NotNull;

public abstract class BaseFragment<ViewModel extends BaseViewModel, Binding extends ViewBinding> extends Fragment {

    protected ViewModel viewModel;
    protected Binding binding;

    @Override
    public void onViewCreated(@NonNull @NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
        setupRequest();
        setupObservers();
        setupNavigation();
    }

    protected void initialize(){}

    protected void setupRequest(){}

    protected void setupObservers(){}

    protected void setupNavigation(){}
}
