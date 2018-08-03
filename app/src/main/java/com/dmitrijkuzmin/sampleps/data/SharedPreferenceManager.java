package com.dmitrijkuzmin.sampleps.data;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface SharedPreferenceManager {
    //String getRegistrationNumber();
    //String getCertificateNumber();
    //String getDriverLicense();

    Observable<String> getRegistrationNumber();
    Observable<String> getCertificateNumber();
    Observable<String> getDriverLicense();

    void setRegistrationNumber(String registrationNumber);
    void setCertificateNumber(String certificateNumber);
    void setDriverLicense(String driverLicense);
}
