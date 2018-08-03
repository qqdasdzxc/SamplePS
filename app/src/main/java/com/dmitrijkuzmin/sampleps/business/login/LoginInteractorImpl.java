package com.dmitrijkuzmin.sampleps.business.login;

import com.dmitrijkuzmin.sampleps.data.SharedPreferenceManager;

public class LoginInteractorImpl implements LoginInteractor {
    private final SharedPreferenceManager preferenceManager;

    public LoginInteractorImpl(SharedPreferenceManager preferenceManager) {
        this.preferenceManager = preferenceManager;
    }

    @Override
    public void setRegistrationNumber(String registrationNumber) {
        preferenceManager.setRegistrationNumber(registrationNumber);
    }

    @Override
    public void setCertificateNumber(String certificateNumber) {
        preferenceManager.setCertificateNumber(certificateNumber);
    }

    @Override
    public void setDriverLicense(String driverLicense) {
        preferenceManager.setDriverLicense(driverLicense);
    }

    @Override
    public void clearRegistrationNumber() {
        preferenceManager.clearRegistrationNumber();
    }

    @Override
    public void clearCertificateNumber() {
        preferenceManager.clearCertificateNumber();
    }

    @Override
    public void clearDriverLicense() {
        preferenceManager.clearDriverLicense();
    }
}
