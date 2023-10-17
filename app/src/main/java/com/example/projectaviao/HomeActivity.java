package com.example.projectaviao;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    public static final String TAG = "Home Activity";
    private FrameLayout mContainer;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            if
            (item.getItemId() == R.id.navigation) {
                selectedFragment = new HomeFragment();
            } else if
            (item.getItemId() == R.id.navigation2) {
                selectedFragment = new UserFragment();
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_screen, selectedFragment).commit();

            return true;
        });
    }



    public class ClickOnBottomNavigationView implements NavigationBarView.OnItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
     //           case R.id.menuItemUser: showUserFragment();
             //   return true;

            }
            return false;
        }

    }

    private void showUserFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout_items, new UserFragment()).commit();
    }

}
