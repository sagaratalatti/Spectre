package com.sagar.spectre.utils;

import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;
import com.sagar.spectre.R;

public class MainUtils {

    public static void showSnackbar(ViewGroup parent, String message, int duration) {
        Snackbar snackbar = Snackbar.make(parent, message, duration);
        snackbar.setTextColor(ContextCompat.getColor(parent.getContext(), R.color.colorAccent));
        snackbar.show();
    }
}
