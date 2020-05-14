package com.sagar.spectre.login.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.sagar.spectre.R;
import com.sagar.spectre.login.utils.LoginCallbackHandler;

public class AgeFragment extends Fragment {

    public AgeFragment() {}

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
        return inflater.inflate(R.layout.fragment_age, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ChipGroup ageGroup = view.findViewById(R.id.ageChipGroup);

        ageGroup.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(ChipGroup group, int checkedId) {
                Chip ageChip = group.findViewById(checkedId);

                String age = ageChip.getText().toString();
                mHandler.onSaveAge(3, age);
            }
        });
    }
}
