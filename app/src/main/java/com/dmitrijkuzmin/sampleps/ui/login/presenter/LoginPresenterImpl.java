package com.dmitrijkuzmin.sampleps.ui.login.presenter;

import com.dmitrijkuzmin.sampleps.business.login.LoginInteractor;
import com.dmitrijkuzmin.sampleps.ui.login.view.LoginView;
import com.dmitrijkuzmin.sampleps.utils.Validator;

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView view;
    private LoginInteractor interactor;

    public LoginPresenterImpl(LoginView view, LoginInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void startLogin() {
        view.moveToFirstLoginStep();
    }

    @Override
    public void finishFirstStep(String registrationNumber) {
        if (Validator.isRegistrationNumberValid(registrationNumber)) {
            interactor.setRegistrationNumber(registrationNumber);
            view.moveToSecondLoginStep();
        }
    }

    @Override
    public void finishSecondStep(String certificateNumber) {
        if (Validator.isCertificateNumberValid(certificateNumber)) {
            interactor.setCertificateNumber(certificateNumber);
            view.moveToThirdLoginStep();
        }
    }

    @Override
    public void finishThirdStep(String driverLicense) {
        if (Validator.isDriverLicenseValid(driverLicense)) {
            interactor.setDriverLicense(driverLicense);
            view.moveToOnBoardScreen();
        }
    }

    @Override
    public void finishFirstStep() {
        interactor.clearRegistrationNumber();
        view.moveToSecondLoginStep();
    }

    @Override
    public void finishSecondStep() {
        interactor.clearCertificateNumber();
        view.moveToThirdLoginStep();
    }

    @Override
    public void finishThirdStep() {
        interactor.clearDriverLicense();
        view.moveToOnBoardScreen();
    }

    @Override
    public void tryToSkipFirstStep() {
        view.showFirstStepWarningDialog();
    }

    @Override
    public void tryToSkipSecondStep() {
        view.showSecondStepWarningDialog();
    }

    @Override
    public void tryToSkipThirdStep() {
        view.showThirdStepWarningDialog();
    }
}
