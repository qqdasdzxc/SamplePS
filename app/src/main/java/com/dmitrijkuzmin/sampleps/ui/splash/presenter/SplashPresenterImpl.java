package com.dmitrijkuzmin.sampleps.ui.splash.presenter;

import com.dmitrijkuzmin.sampleps.business.splash.SplashInteractor;
import com.dmitrijkuzmin.sampleps.ui.splash.view.SplashView;

public class SplashPresenterImpl implements SplashPresenter {

    private final SplashView view;
    private final SplashInteractor interactor;

    public SplashPresenterImpl(SplashView view, SplashInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

}
