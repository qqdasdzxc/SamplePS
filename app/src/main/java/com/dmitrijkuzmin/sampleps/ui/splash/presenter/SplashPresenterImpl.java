package com.dmitrijkuzmin.sampleps.ui.splash.presenter;

import com.dmitrijkuzmin.sampleps.business.splash.SplashInteractor;
import com.dmitrijkuzmin.sampleps.ui.splash.view.SplashView;

import io.reactivex.disposables.Disposable;

public class SplashPresenterImpl implements SplashPresenter {

    private SplashView view;
    private SplashInteractor interactor;
    private Disposable disposable;

    public SplashPresenterImpl(SplashView view, SplashInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void verifyUser() {
        disposable = interactor.verifyUser().subscribe(this::controlView, throwable -> {});
    }

    @Override
    public void cancelVerifying() {
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }

        view = null;
        interactor = null;
    }

    private void controlView(boolean result) {
        if (result) {
            view.moveToPreMainScreen();
        } else {
            view.moveToPreLoginScreen();
        }
    }
}
