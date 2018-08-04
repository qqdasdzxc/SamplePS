package com.dmitrijkuzmin.sampleps.business.main;

import io.reactivex.Observable;

public interface MainInteractor {
    Observable<String> getRegistrationNumber();
    Observable<String> getCertificateNumber();
    Observable<String> getDriverLicense();
}
