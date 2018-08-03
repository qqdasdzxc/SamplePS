package com.dmitrijkuzmin.sampleps.di.app;

import com.dmitrijkuzmin.sampleps.di.login.LoginComponent;
import com.dmitrijkuzmin.sampleps.di.login.LoginModule;
import com.dmitrijkuzmin.sampleps.di.splash.SplashComponent;
import com.dmitrijkuzmin.sampleps.di.splash.SplashModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    SplashComponent plus(SplashModule module);
    LoginComponent plus(LoginModule module);
}
