package com.dmitrijkuzmin.sampleps.business.splash;

import com.dmitrijkuzmin.sampleps.data.SharedPreferenceManager;
import com.dmitrijkuzmin.sampleps.utils.Constants;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SplashInteractorImpl implements SplashInteractor {

    private final SharedPreferenceManager manager;
    private Disposable disposable;

    public SplashInteractorImpl(SharedPreferenceManager manager) {
        this.manager = manager;
    }

    @Override
    public Observable<Boolean> verifyUser() {
        return Observable.zip(manager.getRegistrationNumber(),
                manager.getCertificateNumber(), manager.getDriverLicense(),
                this::verifyPreferences)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(Boolean::booleanValue);
    }

    private boolean verifyPreferences(String registrationNumber, String certificateNumber, String driverLicense) {
        return !registrationNumber.equals(Constants.EMPTY_PREFERENCE) &&
                !certificateNumber.equals(Constants.EMPTY_PREFERENCE) &&
                !driverLicense.equals(Constants.EMPTY_PREFERENCE);
    }


}
