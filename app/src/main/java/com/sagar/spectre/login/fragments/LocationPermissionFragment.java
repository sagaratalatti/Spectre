package com.sagar.spectre.login.fragments;

import android.Manifest;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.sagar.spectre.R;
import com.sagar.spectre.login.utils.LoginCallbackHandler;

public class LocationPermissionFragment extends PermissionFragment {

    public LocationPermissionFragment() {}

    @Override
    protected int getRequestPermission() {
        return 1;
    }

    @Override
    protected String[] getPermissions() {
        return new String[0];
    }

    @Override
    protected String getFragmentTag() {
        return LocationPermissionFragment.class.getSimpleName();
    }

    @Override
    protected int getPermissionLogo() {
        return R.drawable.ic_street_map;
    }

    @Override
    protected int getBackgroundColor() {
        return R.color.iris_purple;
    }

    @Override
    protected String getPermission() {
        return Manifest.permission.ACCESS_FINE_LOCATION;
    }

    @Override
    protected String getPermissionDescription() {
        return "Allow Spectre to access your location, Spectre collects your location data to provide with content based on your geolocation. Your location measured in distance could be shared with the users on this platform. ";
    }

    @Override
    protected String getPermissionRequest1() {
        return null;
    }

    @Override
    protected String getPermissionRequest2() {
        return null;
    }
}
