package com.dmitrijkuzmin.sampleps.di.splash;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.dmitrijkuzmin.sampleps.business.splash.SplashInteractor;
import com.dmitrijkuzmin.sampleps.business.splash.SplashInteractorImpl;
import com.dmitrijkuzmin.sampleps.data.SharedPreferenceManager;
import com.dmitrijkuzmin.sampleps.ui.splash.presenter.SplashPresenter;
import com.dmitrijkuzmin.sampleps.ui.splash.presenter.SplashPresenterImpl;
import com.dmitrijkuzmin.sampleps.ui.splash.view.SplashView;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashModule {

    private final SplashView view;

    public SplashModule(SplashView view) {
        this.view = view;
    }

    @SplashScope
    @Provides
    public SplashView provideSplashView() {
        return view;
    }

    @SplashScope
    @Provides
    public SplashInteractor provideSplashInteractor(SharedPreferenceManager sharedPreferenceManager) {
        return new SplashInteractorImpl(sharedPreferenceManager);
    }

    @SplashScope
    @Provides
    public SplashPresenter provideSplashPresenter(SplashView view, SplashInteractor interactor) {
        return new SplashPresenterImpl(view, interactor);
    }
}
