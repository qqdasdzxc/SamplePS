package com.dmitrijkuzmin.sampleps.business.main;

import com.dmitrijkuzmin.sampleps.data.SharedPreferenceManager;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainInteractorImpl implements MainInteractor {

    private SharedPreferenceManager preferenceManager;

    public MainInteractorImpl(SharedPreferenceManager preferenceManager) {
        this.preferenceManager = preferenceManager;
    }

    @Override
    public Observable<String> getRegistrationNumber() {
        return preferenceManager.getRegistrationNumber()
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<String> getCertificateNumber() {
        return preferenceManager.getCertificateNumber()
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<String> getDriverLicense() {
        return preferenceManager.getDriverLicense()
                .observeOn(AndroidSchedulers.mainThread());
    }
}
