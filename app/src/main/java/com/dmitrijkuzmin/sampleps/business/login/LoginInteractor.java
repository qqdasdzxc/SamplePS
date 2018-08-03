package com.dmitrijkuzmin.sampleps.business.login;

public interface LoginInteractor {
    void setRegistrationNumber(String registrationNumber);
    void setCertificateNumber(String certificateNumber);
    void setDriverLicense(String driverLicense);

    void clearRegistrationNumber();
    void clearCertificateNumber();
    void clearDriverLicense();

}
