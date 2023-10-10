package com.example.projectaviao;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    public static final String TAG = "Home Activity";
    private FrameLayout mContainer;
    private BottomNavigationView mBottomNavigationView;


    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.home_activity);


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
