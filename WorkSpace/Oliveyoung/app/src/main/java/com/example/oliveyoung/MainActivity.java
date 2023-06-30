package com.example.oliveyoung;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.example.oliveyoung.databinding.ActivityMainBinding;
import com.example.oliveyoung.home.HomeFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //getSupportFragmentManager().beginTransaction().replace(R.id.container, new FriendFragment()).commit();

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
                    Fragment fragment = null;
                    if (item.getItemId() == R.id.tab1) {

                    } else if (item.getItemId() == R.id.tab2) {

                    } else if (item.getItemId() == R.id.tab3) {
                        fragment = new HomeFragment();
                    } else if (item.getItemId() == R.id.tab4) {

                    } else if (item.getItemId() == R.id.tab5) {

                    } else {
                        return false;
                    }
                    if (fragment == null) {
                        Toast.makeText(this, "아직 메뉴가 준비가 안되었습니다.", Toast.LENGTH_SHORT).show();
                    } else {
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                    }
                    return true;

                });

        binding.bottomNavigation.setSelectedItemId(R.id.tab3);

    }
}