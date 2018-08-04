package com.dmitrijkuzmin.sampleps.presenter;

import com.dmitrijkuzmin.sampleps.business.login.LoginInteractor;
import com.dmitrijkuzmin.sampleps.ui.login.presenter.LoginPresenter;
import com.dmitrijkuzmin.sampleps.ui.login.presenter.LoginPresenterImpl;
import com.dmitrijkuzmin.sampleps.ui.login.view.LoginView;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class LoginPresenterTest {

    private LoginView view;
    private LoginInteractor interactor;
    private LoginPresenter presenter;

    @Before
    public void setup() {
        view = mock(LoginView.class);
        interactor = mock(LoginInteractor.class);
        presenter = new LoginPresenterImpl(view, interactor);
    }

    @Test
    public void testFinishingFirstStepWithResult() {
        presenter.finishFirstStep("А111АА11");

        verify(interactor).setRegistrationNumber("А111АА11");
        verify(view).moveToSecondLoginStep();
    }
}
