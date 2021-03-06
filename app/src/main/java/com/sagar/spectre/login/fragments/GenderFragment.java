package com.sagar.spectre.login.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.sagar.spectre.R;
import com.sagar.spectre.login.utils.LoginCallbackHandler;

public class GenderFragment extends Fragment {

    public GenderFragment() {}

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
        return inflater.inflate(R.layout.fragment_gender, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final MaterialButtonToggleGroup genderToggle = view.findViewById(R.id.genderToggleButton);

        genderToggle.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                if (isChecked) {
                    MaterialButton genderButton = group.findViewById(checkedId);
                    String gender = genderButton.getText().toString();
                    mHandler.onSaveGender(2, gender);
                }
            }
        });
    }
}
