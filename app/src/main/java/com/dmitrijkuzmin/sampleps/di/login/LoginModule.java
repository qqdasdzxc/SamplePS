package com.dmitrijkuzmin.sampleps.di.login;

import com.dmitrijkuzmin.sampleps.business.login.LoginInteractor;
import com.dmitrijkuzmin.sampleps.business.login.LoginInteractorImpl;
import com.dmitrijkuzmin.sampleps.data.SharedPreferenceManager;
import com.dmitrijkuzmin.sampleps.ui.login.presenter.LoginPresenter;
import com.dmitrijkuzmin.sampleps.ui.login.presenter.LoginPresenterImpl;
import com.dmitrijkuzmin.sampleps.ui.login.view.LoginView;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    private final LoginView view;

    public LoginModule(LoginView view) {
        this.view = view;
    }

    @LoginScope
    @Provides
    public LoginView provideLoginView() {
        return view;
    }

    @LoginScope
    @Provides
    public LoginInteractor provideLoginInteractor(SharedPreferenceManager sharedPreferenceManager) {
        return new LoginInteractorImpl(sharedPreferenceManager);
    }

    @LoginScope
    @Provides
    public LoginPresenter provideLoginPresenter(LoginView view, LoginInteractor interactor) {
        return new LoginPresenterImpl(view, interactor);
    }
}
