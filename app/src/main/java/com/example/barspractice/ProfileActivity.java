package com.example.barspractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.barspractice.databinding.ActivityMainBinding;
import com.example.barspractice.databinding.ActivityProfileBinding;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationBarView;

public class ProfileActivity extends AppCompatActivity {


    ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.topAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        binding.bottomMenu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if (id == R.id.info){
                    changeFragments(new InfoFragment());
                    binding.topAppBar.setTitle("Информация");
                    return true;
                }
                if (id == R.id.selected_news){
                    changeFragments(new SelectedFragment());
                    binding.topAppBar.setTitle("Избранное");
                    return true;
                }
                if (id == R.id.settings){
                    changeFragments(new SettingsFragment());
                    binding.topAppBar.setTitle("Настройки");
                    return true;
                }

                return false;
            }
        });


    }

    public void changeFragments(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.profile_fragment_place, fragment, null)
                .commit();
    }

}