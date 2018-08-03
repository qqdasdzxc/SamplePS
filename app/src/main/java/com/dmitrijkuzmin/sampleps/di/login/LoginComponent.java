package com.dmitrijkuzmin.sampleps.di.login;

import com.dmitrijkuzmin.sampleps.ui.login.view.LoginActivity;

import dagger.Subcomponent;

@LoginScope
@Subcomponent(modules = {LoginModule.class})
public interface LoginComponent {
    void inject(LoginActivity activity);
}
