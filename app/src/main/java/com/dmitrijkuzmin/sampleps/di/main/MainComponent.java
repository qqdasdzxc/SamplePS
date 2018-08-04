package com.dmitrijkuzmin.sampleps.di.main;

import com.dmitrijkuzmin.sampleps.ui.main.view.MainActivity;

import dagger.Subcomponent;

@MainScope
@Subcomponent(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
}
