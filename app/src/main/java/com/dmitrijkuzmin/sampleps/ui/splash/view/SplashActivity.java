package com.dmitrijkuzmin.sampleps.ui.splash.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dmitrijkuzmin.sampleps.App;
import com.dmitrijkuzmin.sampleps.R;
import com.dmitrijkuzmin.sampleps.di.splash.SplashModule;
import com.dmitrijkuzmin.sampleps.ui.splash.presenter.SplashPresenter;

import javax.inject.Inject;

public class SplashActivity extends AppCompatActivity implements SplashView,
        PreLoginFragment.PreLoginListener, PreMainFragment.PreMainListener {

    @Inject
    SplashPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ((App) getApplicationContext()).getAppComponent()
                .plus(new SplashModule(this)).inject(this);

        presenter.verifyUser();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.cancelVerifying();
    }

    @Override
    public void moveToPreLoginScreen() {
        //фрагмент с опцией "ВВЕСТИ ДАННЫЕ"
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new PreLoginFragment())
                .commit();
    }

    @Override
    public void moveToPreMainScreen() {
        //фрагмент с опцией "ПРОДОЛЖИТЬ"
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new PreMainFragment())
                .commit();
    }

    @Override
    public void moveToLoginScreen() {

    }

    @Override
    public void moveToMainScreen() {

    }
}
