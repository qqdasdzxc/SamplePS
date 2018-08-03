package com.dmitrijkuzmin.sampleps.ui.login.view;

public interface LoginView {
    void moveToFirstLoginStep();
    void moveToSecondLoginStep();
    void moveToThirdLoginStep();
    void moveToOnBoardScreen();

    void showFirstStepWarningDialog();
    void showSecondStepWarningDialog();
    void showThirdStepWarningDialog();

    void backToPreviousStep();
}
