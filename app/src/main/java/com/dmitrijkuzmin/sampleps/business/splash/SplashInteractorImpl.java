package com.dmitrijkuzmin.sampleps.business.splash;

import com.dmitrijkuzmin.sampleps.data.SharedPreferenceManager;

public class SplashInteractorImpl implements SplashInteractor{

    final SharedPreferenceManager manager;

    public SplashInteractorImpl(SharedPreferenceManager manager) {
        this.manager = manager;
    }
}
