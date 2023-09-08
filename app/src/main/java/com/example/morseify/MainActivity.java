package com.example.morseify;

import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.IDNA;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().
                    setReorderingAllowed(true).
                    add(R.id.fragmentContainerView, morseConverterFragment.class, null).
                    commit();
        }

        NavigationBarView navigationBarView = (NavigationBarView) findViewById(R.id.bottom_navigation);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.v("Tag","Inside nav lister");
                //navigationBarView.setSelectedItemId(R.id.item_2);
                item.setChecked(true);
                if (item.getItemId() == R.id.item_2) {
                    Log.v("Tag","Inside Info selected");
                    //Render info fragment in the fragmentcontainer

                    getSupportFragmentManager().beginTransaction().
                            setReorderingAllowed(true).
                            replace(R.id.fragmentContainerView, InfoFragment.class, null).
                            commit();

                } else if (item.getItemId() == R.id.item_1) {
                    getSupportFragmentManager().beginTransaction().
                            setReorderingAllowed(true).
                            replace(R.id.fragmentContainerView, morseConverterFragment.class, null).
                            commit();
                } else {
                    throw new IllegalStateException("Unexpected value: " + item.getItemId());
            }
            return false;
        }
        });

    }
}