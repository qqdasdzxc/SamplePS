package com.dmitrijkuzmin.sampleps.di.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.dmitrijkuzmin.sampleps.data.SharedPreferenceManager;
import com.dmitrijkuzmin.sampleps.data.SharedPreferenceManagerImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return context;
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Singleton
    @Provides
    public SharedPreferenceManager provideSharedPreferenceManager(SharedPreferences sharedPreferences) {
        return new SharedPreferenceManagerImpl(sharedPreferences);
    }
}
