package com.dmitrijkuzmin.sampleps;

import android.app.Application;

import com.dmitrijkuzmin.sampleps.di.app.AppComponent;
import com.dmitrijkuzmin.sampleps.di.app.AppModule;
import com.dmitrijkuzmin.sampleps.di.app.DaggerAppComponent;

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
