package com.example.topnt.androidbuttonnavigationbar1;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation_id);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //set color or set page (if open app will have color .)
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_id , new HomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.home_navigation_id :
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.favorites_navigation_id :
                    selectedFragment = new FavoritesFragment();
                    break;
                case R.id.search_navigation_id :
                    selectedFragment = new SearchFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_id , selectedFragment).commit();
            return true;
        }
    };
}
