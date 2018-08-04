package com.dmitrijkuzmin.sampleps.presenter;

import com.dmitrijkuzmin.sampleps.business.main.MainInteractor;
import com.dmitrijkuzmin.sampleps.ui.main.presenter.MainPresenter;
import com.dmitrijkuzmin.sampleps.ui.main.presenter.MainPresenterImpl;
import com.dmitrijkuzmin.sampleps.ui.main.view.MainView;

import org.junit.Before;
import org.junit.Test;

import io.reactivex.Observable;

import static org.mockito.Mockito.*;

public class MainPresenterTest {

    private MainView view;
    private MainInteractor interactor;
    private MainPresenter presenter;

    @Before
    public void setup() {
        view = mock(MainView.class);
        interactor = mock(MainInteractor.class);
        presenter = new MainPresenterImpl(view, interactor);
    }

    @Test
    public void testLoadUserData() {
        when(interactor.getRegistrationNumber()).thenReturn(Observable.just("111111"));
        when(interactor.getCertificateNumber()).thenReturn(Observable.just("222222"));
        when(interactor.getDriverLicense()).thenReturn(Observable.just("333333"));

        presenter.loadUserData();

        verify(view).showRegistrationNumber("111111");
        verify(view).showCertificateNumber("222222");
        verify(view).showDriverLicense("333333");
    }
}
