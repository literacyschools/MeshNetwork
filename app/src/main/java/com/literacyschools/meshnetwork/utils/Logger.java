package com.literacyschools.meshnetwork.utils;

import android.widget.TextView;

/**
 * Created by Elic on 15-04-20.
 */
public class Logger {

    private static TextView textField;

    public static void setTextField(TextView textField) {
        Logger.textField = textField;
    }
    public static void log(String log) {
        textField.setText(textField.getText() + "\n" + log);
    }
}