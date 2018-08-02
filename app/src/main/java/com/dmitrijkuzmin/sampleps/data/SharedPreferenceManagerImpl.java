package com.dmitrijkuzmin.sampleps.data;

import android.content.SharedPreferences;

public class SharedPreferenceManagerImpl implements SharedPreferenceManager {
    private SharedPreferences sharedPreferences;

    public SharedPreferenceManagerImpl(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }
}
