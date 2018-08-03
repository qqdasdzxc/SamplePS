package com.dmitrijkuzmin.sampleps.ui.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.dmitrijkuzmin.sampleps.App;
import com.dmitrijkuzmin.sampleps.R;
import com.dmitrijkuzmin.sampleps.di.login.LoginModule;
import com.dmitrijkuzmin.sampleps.ui.login.presenter.LoginPresenter;
import com.dmitrijkuzmin.sampleps.utils.DialogFactory;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginView,
        FirstLoginStepFragment.FirstLoginStepListener,
        SecondLoginStepFragment.SecondLoginStepListener,
        ThirdLoginStepFragment.ThirdLoginStepListener{

    @Inject
    LoginPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((App) getApplicationContext()).getAppComponent()
                .plus(new LoginModule(this)).inject(this);

        presenter.startLogin();
    }

    @Override
    public void moveToFirstLoginStep() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new FirstLoginStepFragment())
                .commit();
    }

    @Override
    public void moveToSecondLoginStep() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new SecondLoginStepFragment())
                .addToBackStack("second_step")
                .commit();
    }

    @Override
    public void moveToThirdLoginStep() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new ThirdLoginStepFragment())
                .addToBackStack("third_step")
                .commit();
    }

    @Override
    public void moveToOnBoardScreen() {
//        Intent intent = new Intent(this, OnBoardActivity.class);
//        startActivity(intent);
//        finish();
        Toast.makeText(this, "successful login", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNextFirstStep(String registrationNumber) {
        presenter.finishFirstStep(registrationNumber);
    }

    @Override
    public void onSkipFirstStep() {
        presenter.tryToSkipFirstStep();
    }

    @Override
    public void onNextSecondStep(String certificateNumber) {
        presenter.finishSecondStep(certificateNumber);
    }

    @Override
    public void onSkipSecondStep() {
        presenter.tryToSkipSecondStep();
    }

    @Override
    public void onNextThirdStep(String driverLicense) {
        presenter.finishThirdStep(driverLicense);
    }

    @Override
    public void onSkipThirdStep() {
        presenter.tryToSkipThirdStep();
    }

    @Override
    public void showFirstStepWarningDialog() {
        showWarningDialog(getString(R.string.first_step_warning_msg), () -> presenter.finishFirstStep());
    }

    @Override
    public void showSecondStepWarningDialog() {
        showWarningDialog(getString(R.string.second_step_warning_msg), () -> presenter.finishSecondStep());
    }

    @Override
    public void showThirdStepWarningDialog() {
        showWarningDialog(getString(R.string.third_step_warning_msg), () -> presenter.finishThirdStep());
    }

    private void showWarningDialog(String message, DialogFactory.DialogAction action) {
        DialogFactory.createLoginWarningDialog(this, message, action).show();
    }

    @Override
    public void backToPreviousStep() {
        //pop fragment at the top
        getSupportFragmentManager().popBackStack(1, 0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        backToPreviousStep();
    }
}
