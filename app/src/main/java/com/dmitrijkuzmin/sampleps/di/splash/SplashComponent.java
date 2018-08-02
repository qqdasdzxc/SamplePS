package com.dmitrijkuzmin.sampleps.di.splash;

import com.dmitrijkuzmin.sampleps.di.app.AppComponent;
import com.dmitrijkuzmin.sampleps.ui.splash.view.SplashActivity;

import dagger.Component;
import dagger.Subcomponent;

@SplashScope
@Subcomponent(modules = {SplashModule.class})
public interface SplashComponent {
    void inject(SplashActivity activity);
}
