package com.dmitrijkuzmin.sampleps.ui.main.presenter;

import com.dmitrijkuzmin.sampleps.business.main.MainInteractor;
import com.dmitrijkuzmin.sampleps.ui.main.view.MainView;

import io.reactivex.disposables.CompositeDisposable;

public class MainPresenterImpl implements MainPresenter {

    private MainView view;
    private MainInteractor interactor;
    private CompositeDisposable disposable;

    public MainPresenterImpl(MainView view, MainInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void loadUserData() {
        disposable = new CompositeDisposable();
        loadRegistrationNumber();
        loadCertificateNumber();
        loadDriverLicense();
    }

    private void loadRegistrationNumber() {
        disposable.add(interactor.getRegistrationNumber()
                .subscribe(registrationNumber -> view.showRegistrationNumber(registrationNumber)));
    }

    private void loadCertificateNumber() {
        disposable.add(interactor.getCertificateNumber()
                .subscribe(certificateNumber -> view.showCertificateNumber(certificateNumber)));
    }

    private void loadDriverLicense() {
        disposable.add(interactor.getDriverLicense()
                .subscribe(driverLicense -> view.showDriverLicense(driverLicense)));
    }

    @Override
    public void cancelLoading() {
        disposable.dispose();
    }
}
