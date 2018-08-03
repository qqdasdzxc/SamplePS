package com.dmitrijkuzmin.sampleps.business.splash;


import io.reactivex.Observable;

public interface SplashInteractor {
    Observable<Boolean> verifyUser();
}
