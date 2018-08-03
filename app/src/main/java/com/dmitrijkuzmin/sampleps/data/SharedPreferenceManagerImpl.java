package com.dmitrijkuzmin.sampleps.data;

import android.content.SharedPreferences;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

import static com.dmitrijkuzmin.sampleps.utils.Constants.*;

public class SharedPreferenceManagerImpl implements SharedPreferenceManager {
    private SharedPreferences sharedPreferences;

    public SharedPreferenceManagerImpl(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public Observable<String> getRegistrationNumber() {
        return Observable.fromCallable(() -> sharedPreferences.getString(REGISTRATION_NUMBER, EMPTY_PREFERENCE))
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<String> getCertificateNumber() {
        return Observable.fromCallable(() -> sharedPreferences.getString(CERTIFICATE_NUMBER, EMPTY_PREFERENCE))
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<String> getDriverLicense() {
        return Observable.fromCallable(() -> sharedPreferences.getString(DRIVER_LICENSE, EMPTY_PREFERENCE))
                .subscribeOn(Schedulers.io());
    }

    @Override
    public void setRegistrationNumber(String registrationNumber) {
        sharedPreferences.edit()
                .putString(REGISTRATION_NUMBER, registrationNumber)
                .apply();
    }

    @Override
    public void setCertificateNumber(String certificateNumber) {
        sharedPreferences.edit()
                .putString(CERTIFICATE_NUMBER, certificateNumber)
                .apply();
    }

    @Override
    public void setDriverLicense(String driverLicense) {
        sharedPreferences.edit()
                .putString(DRIVER_LICENSE, driverLicense)
                .apply();
    }

    @Override
    public void clearRegistrationNumber() {
        sharedPreferences.edit()
                .remove(REGISTRATION_NUMBER)
                .apply();
    }

    @Override
    public void clearCertificateNumber() {
        sharedPreferences.edit()
                .remove(CERTIFICATE_NUMBER)
                .apply();
    }

    @Override
    public void clearDriverLicense() {
        sharedPreferences.edit()
                .remove(DRIVER_LICENSE)
                .apply();
    }
}
