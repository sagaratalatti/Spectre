package com.sagar.spectre.login.fragments;


import android.Manifest;

import com.sagar.spectre.R;

public class StoragePermissionFragment extends PermissionFragment {

    public StoragePermissionFragment() {
    }

    @Override
    protected int getRequestPermission() {
        return 2;
    }

    @Override
    protected String[] getPermissions() {
        return new String [] {Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE};
    }

    @Override
    protected String getFragmentTag() {
        return StoragePermissionFragment.class.getSimpleName();
    }

    @Override
    protected int getPermissionLogo() {
        return R.drawable.ic_cellphone;
    }

    @Override
    protected int getBackgroundColor() {
        return R.color.dark_purple;
    }

    @Override
    protected String getPermission() {
        return null;
    }

    @Override
    protected String getPermissionDescription() {
        return "Allow Spectre to access your storage, Spectre will store user's details and database on user's local storage. User can also upload data from local storage to Spectre database, will enable smooth app functioning.";
    }

    @Override
    protected String getPermissionRequest1() {
        return Manifest.permission.READ_EXTERNAL_STORAGE;
    }

    @Override
    protected String getPermissionRequest2() {
        return Manifest.permission.WRITE_EXTERNAL_STORAGE;
    }
}
