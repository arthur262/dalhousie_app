package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.switchbar);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer, new Home()).commit();
        }

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.home: {
                        fragment = new Home();
                        break;
                    }
                    case R.id.Setting: {
                        fragment = new Setting();
                        break;
                    }
                    case R.id.Future_plan: {
                        fragment = new future_plan();
                        break;
                    }
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer, fragment).commit();

                return;
            }
        });
    }
}