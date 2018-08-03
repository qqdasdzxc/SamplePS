package com.dmitrijkuzmin.sampleps.utils;

import android.app.AlertDialog;
import android.content.Context;

import com.dmitrijkuzmin.sampleps.R;

public class DialogFactory {

    public static AlertDialog createLoginWarningDialog(Context context, String message, DialogAction action) {
        return new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton(context.getString(R.string.next_button_text),
                        (dialogInterface, i) -> {
                            action.onPositive();
                        })
                .setNegativeButton(context.getString(R.string.negative_button_warning_dialog_login_text),
                        (dialogInterface, i) -> {
                            dialogInterface.dismiss();
                        })
                .create();
    }

    public interface DialogAction {
        void onPositive();
    }
}
