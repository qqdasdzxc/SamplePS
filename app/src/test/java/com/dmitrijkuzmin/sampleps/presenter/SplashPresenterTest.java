package com.dmitrijkuzmin.sampleps.presenter;

import com.dmitrijkuzmin.sampleps.business.splash.SplashInteractor;
import com.dmitrijkuzmin.sampleps.ui.splash.presenter.SplashPresenter;
import com.dmitrijkuzmin.sampleps.ui.splash.presenter.SplashPresenterImpl;
import com.dmitrijkuzmin.sampleps.ui.splash.view.SplashView;

import org.junit.Before;
import org.junit.Test;

import io.reactivex.Observable;

import static org.mockito.Mockito.*;

public class SplashPresenterTest {

    private SplashView view;
    private SplashInteractor interactor;
    private SplashPresenter presenter;

    @Before
    public void setup() {
        view = mock(SplashView.class);
        interactor = mock(SplashInteractor.class);
        presenter = new SplashPresenterImpl(view, interactor);
    }

    @Test
    public void testSuccessVerifyingUser() {
        when(interactor.verifyUser()).thenReturn(Observable.just(true));
        presenter.verifyUser();
        verify(view).moveToPreMainScreen();
    }

    @Test
    public void testFailVerifyingUser() {
        when(interactor.verifyUser()).thenReturn(Observable.just(false));
        presenter.verifyUser();
        verify(view).moveToPreLoginScreen();
    }
}
