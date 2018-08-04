package com.dmitrijkuzmin.sampleps.di.main;

import com.dmitrijkuzmin.sampleps.business.main.MainInteractor;
import com.dmitrijkuzmin.sampleps.business.main.MainInteractorImpl;
import com.dmitrijkuzmin.sampleps.data.SharedPreferenceManager;
import com.dmitrijkuzmin.sampleps.ui.main.presenter.MainPresenter;
import com.dmitrijkuzmin.sampleps.ui.main.presenter.MainPresenterImpl;
import com.dmitrijkuzmin.sampleps.ui.main.view.MainView;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private final MainView view;

    public MainModule(MainView view) {
        this.view = view;
    }

    @MainScope
    @Provides
    public MainView provideMainView() {
        return view;
    }

    @MainScope
    @Provides
    public MainInteractor provideMainInteractor(SharedPreferenceManager sharedPreferenceManager) {
        return new MainInteractorImpl(sharedPreferenceManager);
    }

    @MainScope
    @Provides
    public MainPresenter provideSplashPresenter(MainView view, MainInteractor interactor) {
        return new MainPresenterImpl(view, interactor);
    }
}
