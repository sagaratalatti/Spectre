package com.sagar.spectre.login;


import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;


import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.sagar.spectre.R;
import com.sagar.spectre.login.fragments.ContactsPermissionFragment;
import com.sagar.spectre.login.fragments.LocationPermissionFragment;
import com.sagar.spectre.login.fragments.NameFragment;
import com.sagar.spectre.login.fragments.StoragePermissionFragment;
import com.sagar.spectre.utils.MainUtils;
import com.sagar.spectre.utils.PermissionUtil;
import com.sagar.spectre.utils.ViewPagerFragmentAdapter;

public class LoginActivity extends FragmentActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    private static final String TAG = LoginActivity.class.getSimpleName();

    private static final int LOCATION_REQUEST = 1;
    private static final int STORAGE_REQUEST = 2;
    private static final int CONTACTS_REQUEST = 3;

    private ViewPager2 mViewPager;
    private ViewPagerFragmentAdapter mPagerAdapter;
    private ExtendedFloatingActionButton mNextFabButton;
    private CoordinatorLayout mLoginLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mViewPager = findViewById(R.id.login_viewPager);
        mNextFabButton = findViewById(R.id.login_fbNext);
        mLoginLayout = findViewById(R.id.login_activity_layout);

        mPagerAdapter = new ViewPagerFragmentAdapter(this);

        mPagerAdapter.addFragment(new NameFragment());
        mPagerAdapter.addFragment(new LocationPermissionFragment());
        mPagerAdapter.addFragment(new StoragePermissionFragment());
        mPagerAdapter.addFragment(new ContactsPermissionFragment());

        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setUserInputEnabled(false);

        mNextFabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
            }
        });
    }

    @Override
    public void onBackPressed() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

        if (requestCode == LOCATION_REQUEST) {
            // Received permission result for location permission.
            Log.i(TAG, "Received response for Location permission request.");
            // Check if the only required permission has been granted
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Camera permission has been granted, preview can be displayed
                Log.i(TAG, "Location permission has now been granted. Showing preview.");
                MainUtils.showSnackbar(mLoginLayout, getString(R.string.permission_location_granted), Snackbar.LENGTH_SHORT);
            } else {
                Log.i(TAG, "Location permission was NOT granted.");
                Snackbar.make(mLoginLayout, R.string.permission_location_denied,
                        Snackbar.LENGTH_SHORT).show();

            }

        } else if (requestCode == STORAGE_REQUEST) {
            Log.i(TAG, "Received response for contact permissions request.");

            // We have requested multiple permissions for contacts, so all of them need to be
            // checked.
            if (PermissionUtil.verifyPermissions(grantResults)) {
                // All required permissions have been granted, to read & write storage.
                Snackbar.make(mLoginLayout, R.string.permission_storage_granted,
                        Snackbar.LENGTH_SHORT)
                        .show();
            } else {
                Log.i(TAG, "Storage permissions were NOT granted.");
                Snackbar.make(mLoginLayout, R.string.permission_storage_denied,
                        Snackbar.LENGTH_SHORT)
                        .show();
            }
        } else if (requestCode == CONTACTS_REQUEST) {
            Log.i(TAG, "Received response for contact permissions request.");

            // We have requested multiple permissions for contacts, so all of them need to be
            // checked.
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Required permission have been granted, to read contacts.
                Log.i(TAG, "Contacts permission has now been granted.");
                Snackbar.make(mLoginLayout, R.string.permission_contacts_granted,
                        Snackbar.LENGTH_SHORT)
                        .show();
            } else {
                Log.i(TAG, "Contacts permissions were NOT granted.");
                Snackbar.make(mLoginLayout, R.string.permission_contacts_denied,
                        Snackbar.LENGTH_SHORT)
                        .show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

}
