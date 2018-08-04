package com.dmitrijkuzmin.sampleps.ui.main.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.dmitrijkuzmin.sampleps.App;
import com.dmitrijkuzmin.sampleps.R;
import com.dmitrijkuzmin.sampleps.di.main.MainModule;
import com.dmitrijkuzmin.sampleps.ui.main.presenter.MainPresenter;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView {

    @Inject
    MainPresenter presenter;

    TextView registrationNumbertv, certificateNumbertv, driverLicensetv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registrationNumbertv = findViewById(R.id.registration_number_tv);
        certificateNumbertv = findViewById(R.id.certificate_number_tv);
        driverLicensetv = findViewById(R.id.driver_license_tv);

        ((App) getApplicationContext()).getAppComponent()
                .plus(new MainModule(this)).inject(this);

        presenter.loadUserData();
    }

    @Override
    public void showRegistrationNumber(String registrationNumber) {
        registrationNumbertv.setText(registrationNumber);
    }

    @Override
    public void showCertificateNumber(String certificateNumber) {
        certificateNumbertv.setText(certificateNumber);
    }

    @Override
    public void showDriverLicense(String driverLicense) {
        driverLicensetv.setText(driverLicense);
    }
}
