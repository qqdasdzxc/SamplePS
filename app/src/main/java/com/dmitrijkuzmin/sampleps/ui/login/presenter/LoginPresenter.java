package com.dmitrijkuzmin.sampleps.ui.login.presenter;

public interface LoginPresenter {
    void startLogin();

    void finishFirstStep(String registrationNumber);
    void finishFirstStep();
    void tryToSkipFirstStep();

    void finishSecondStep(String certificateNumber);
    void finishSecondStep();
    void tryToSkipSecondStep();

    void finishThirdStep(String driverLicense);
    void finishThirdStep();
    void tryToSkipThirdStep();

}
