package com.sagar.spectre.login.fragments;

import android.Manifest;

import com.sagar.spectre.R;

public class ContactsPermissionFragment extends PermissionFragment {

    public ContactsPermissionFragment() {}

    @Override
    protected int getRequestPermission() {
        return 3;
    }

    @Override
    protected String[] getPermissions() {
        return new String[0];
    }

    @Override
    protected String getFragmentTag() {
        return ContactsPermissionFragment.class.getSimpleName();
    }

    @Override
    protected int getPermissionLogo() {
        return R.drawable.ic_people;
    }

    @Override
    protected int getBackgroundColor() {
        return R.color.northwestern_purple;
    }

    @Override
    protected String getPermission() {
        return Manifest.permission.READ_CONTACTS;
    }

    @Override
    protected String getPermissionDescription() {
        return "Allow Spectre to access your contacts, Spectre will use your contacts directory to find your contacts on Spectre database to allow anonymous interaction with your phone contacts.";
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
