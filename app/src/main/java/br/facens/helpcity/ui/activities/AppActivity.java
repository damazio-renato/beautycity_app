package br.facens.helpcity.ui.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.navigation.NavigationBarView;

import br.facens.helpcity.R;
import br.facens.helpcity.databinding.ActivityAppBinding;
import br.facens.helpcity.ui.fragments.app.DashboardFragment;
import br.facens.helpcity.ui.fragments.app.HomeFragment;
import br.facens.helpcity.ui.fragments.app.ProfileFragment;
import br.facens.helpcity.ui.fragments.app.RequestFragment;
import br.facens.helpcity.ui.fragments.app.SettingsFragment;
import br.facens.helpcity.utils.AppFunction;

public class AppActivity extends AppCompatActivity {

    private ActivityAppBinding binding;
    private AppFunction appFunction;
    private int activeMenu;
    private String animationSide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAppBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        appFunction = AppFunction.getInstance();

        binding.bnvAppMain.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    if (activeMenu != 1) {
                        appFunction.replaceFragment(
                                getSupportFragmentManager(),
                                new HomeFragment(),
                                null,
                                R.id.fmlAppMain,
                                activeMenu < 1 ? "DE" : "ED"
                        );
                        activeMenu = 1;
                    }
                } else if (itemId == R.id.dashboard) {
                    if (activeMenu != 2) {
                        appFunction.replaceFragment(
                                getSupportFragmentManager(),
                                new DashboardFragment(),
                                null,
                                R.id.fmlAppMain,
                                activeMenu < 2 ? "DE" : "ED"
                        );
                        activeMenu = 2;
                    }
//                } else if (itemId == R.id.requests) {
//                    if (activeMenu != 3) {
//                        appFunction.replaceFragment(
//                                getSupportFragmentManager(),
//                                new RequestFragment(),
//                                null,
//                                R.id.fmlAppMain,
//                                activeMenu < 3 ? "DE" : "ED"
//                        );
//                        activeMenu = 3;
//                    }
                } else if (itemId == R.id.profile) {
                    if (activeMenu != 4) {
                        appFunction.replaceFragment(
                                getSupportFragmentManager(),
                                new ProfileFragment(),
                                null,
                                R.id.fmlAppMain,
                                activeMenu < 4 ? "DE" : "ED"
                        );
                        activeMenu = 4;
                    }
                } else if (itemId == R.id.settings) {
                    if (activeMenu != 5) {
                        appFunction.replaceFragment(
                                getSupportFragmentManager(),
                                new SettingsFragment(),
                                null,
                                R.id.fmlAppMain,
                                activeMenu < 5 ? "DE" : "ED"
                        );
                        activeMenu = 5;
                    }
                }
                return true;
            }
        });

        activeMenu = 1;
        animationSide = "DE";
        appFunction.replaceFragment(
                getSupportFragmentManager(),
                new HomeFragment(),
                null,
                R.id.fmlAppMain,
                animationSide
        );
    }
}