package com.sagar.spectre.login;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;


import com.sagar.spectre.R;
import com.sagar.spectre.login.fragments.LocationPermissionFragment;
import com.sagar.spectre.utils.ViewPagerFragmentAdapter;

public class LoginActivity extends FragmentActivity {

    private ViewPager2 mViewPager;
    private ViewPagerFragmentAdapter mPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mViewPager = findViewById(R.id.login_viewPager);

        mPagerAdapter = new ViewPagerFragmentAdapter(this);

        mPagerAdapter.addFragment(new LocationPermissionFragment());
//        mPagerAdapter.addFragment(new Fragmenttwo());
//        mPagerAdapter.addFragment(new FragmentThree());

        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setUserInputEnabled(false);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        getSupportFragmentManager().popBackStack();
    }
}
