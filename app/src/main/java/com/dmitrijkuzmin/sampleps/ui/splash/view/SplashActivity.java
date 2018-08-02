package com.dmitrijkuzmin.sampleps.ui.splash.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dmitrijkuzmin.sampleps.App;
import com.dmitrijkuzmin.sampleps.di.splash.SplashModule;
import com.dmitrijkuzmin.sampleps.ui.splash.presenter.SplashPresenter;

import javax.inject.Inject;

public class SplashActivity extends AppCompatActivity implements SplashView {

    @Inject
    SplashPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((App) getApplicationContext()).getAppComponent()
                .plus(new SplashModule(this)).inject(this);
    }
}
