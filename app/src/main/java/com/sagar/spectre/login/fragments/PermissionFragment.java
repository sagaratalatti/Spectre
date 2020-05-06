package com.sagar.spectre.login.fragments;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.sagar.spectre.R;

public abstract class PermissionFragment extends Fragment {

    private static final int REQUEST_CAMERA = 0;
    private static String[] PERMISSIONS_CONTACT = {Manifest.permission.READ_CONTACTS,
            Manifest.permission.WRITE_CONTACTS};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_permission, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutCompat permissionLayout = view.findViewById(R.id.permission_layout);
        ImageView permissionLogo = view.findViewById(R.id.permission_ImageView);
        TextView permissionDescription = view.findViewById(R.id.permission_description);
        MaterialButton permissionRequestBtn = view.findViewById(R.id.request_permissionBtn);

        //permissionLayout.setBackgroundColor(getBackgroundColor());
        permissionLogo.setImageDrawable(getContext().getDrawable(getPermissionLogo()));
        permissionLogo.setContentDescription(getPermissionDescription());
        permissionDescription.setText(getPermissionDescription());

        permissionRequestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission(getPermission());
            }
        });
    }

    protected abstract int getRequestPermission();

    protected abstract String[] getPermissions();

    protected abstract String getFragmentTag();

    protected abstract int getPermissionLogo();

    protected abstract int getBackgroundColor();

    protected abstract String getPermission();

    protected abstract String getPermissionDescription();

    private void requestPermission(String permission) {
        Log.i(getFragmentTag(), "CAMERA permission has NOT been granted. Requesting permission.");
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), permission)) {
            // Provide an additional rationale to the user if the permission was not granted
            // and the user would benefit from additional context for the use of the permission.
            // For example if the user has previously denied the permission.
            Log.i(getFragmentTag(), "Displaying camera permission rationale to provide additional context.");
                            ActivityCompat.requestPermissions(getActivity(),
                                    new String[]{permission},
                                    getRequestPermission());
        } else {
            // Camera permission has not been granted yet. Request it directly.
            ActivityCompat.requestPermissions(getActivity(), new String[]{permission},
                    getRequestPermission());
        }
        // Permission not granted.
    }

}
