package com.sagar.spectre.login.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.sagar.spectre.R;
import com.sagar.spectre.login.utils.LoginCallbackHandler;

public class NameFragment extends Fragment {

    public NameFragment() {}

    private LoginCallbackHandler mHandler;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() instanceof LoginCallbackHandler)
            mHandler = (LoginCallbackHandler) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_username, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final TextInputEditText username = view.findViewById(R.id.login_username);
        final TextInputLayout usernameInputLayout = view.findViewById(R.id.usernameInputLayout);

        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Nothing to do here
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Nothing to do here
            }

            @Override
            public void afterTextChanged(Editable string) {
                if (string.length() != 0) {
                    if (string.toString().matches(getString(R.string.app_name))) {
                        usernameInputLayout.setError(getString(R.string.cannot_use_boo));
                    } else if (string.length() != 0 && !string.toString().matches(getString(R.string.app_name))) {
                        usernameInputLayout.setError(null);
                        mHandler.onSaveUsername(1, string.toString());
                    }
                } else {
                    usernameInputLayout.setError(getString(R.string.username_not_blank));
                }
            }
        });
    }
}
