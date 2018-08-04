package com.dmitrijkuzmin.sampleps.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.dmitrijkuzmin.sampleps.business.splash.SplashInteractor;
import com.dmitrijkuzmin.sampleps.di.splash.SplashModule;
import com.dmitrijkuzmin.sampleps.ui.splash.presenter.SplashPresenter;
import com.dmitrijkuzmin.sampleps.ui.splash.view.SplashActivity;
import com.dmitrijkuzmin.sampleps.ui.splash.view.SplashView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;

@RunWith(AndroidJUnit4.class)
public class SplashViewTest {

    private SplashPresenter presenter;
    private SplashView view;

    @Rule
    public ActivityTestRule<SplashActivity> activity =
            new ActivityTestRule<>(SplashActivity.class, false, false);

    @Before
    public void setup() {
        SplashModule splashModule = mock(SplashModule.class);
        presenter = mock(SplashPresenter.class);

        when(splashModule.provideSplashView()).thenReturn(mock(SplashView.class));
        when(splashModule.provideSplashPresenter(any(SplashView.class), any(SplashInteractor.class)))
                .thenReturn(presenter);

    }

    @Test
    public void testStartView() {

        activity.launchActivity(new Intent());
        //activity.getActivity().onCreate(new Bundle());
        verify(presenter).verifyUser();
    }
}
