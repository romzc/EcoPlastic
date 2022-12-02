package com.example.ecoplastic.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.ecoplastic.R;
import com.example.ecoplastic.fragments.FourthFragment;
import com.example.ecoplastic.fragments.FragmentCategories;
import com.example.ecoplastic.fragments.FragmentCreateElement;
import com.example.ecoplastic.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    HomeFragment homeFragment = new HomeFragment();
    FragmentCreateElement createElementFragment = new FragmentCreateElement();
    FragmentCategories fragmentCategories = new FragmentCategories();
    FourthFragment fourthFragment = new FourthFragment();
    BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navigation = findViewById(R.id.bottom_navigation_view);
        navigation.setOnItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(homeFragment);
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.firstFragment:
                    loadFragment(homeFragment);
                    return true;
                case R.id.secondFragment:
                    loadFragment(createElementFragment);
                    return true;
                case R.id.thirdFragment:
                    loadFragment(fragmentCategories);
                    return true;
                case R.id.fourthFragment:
                    loadFragment(fourthFragment);
                    return true;
            }
            return false;
        }
    };

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout_principal, fragment);
        transaction.commit();
    }
}