package com.dmitrijkuzmin.sampleps.di.splash;

import com.dmitrijkuzmin.sampleps.ui.splash.view.SplashActivity;

import dagger.Subcomponent;

@SplashScope
@Subcomponent(modules = {SplashModule.class})
public interface SplashComponent {
    void inject(SplashActivity activity);
}
