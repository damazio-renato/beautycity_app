package br.facens.helpcity.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import br.facens.helpcity.R;
import br.facens.helpcity.databinding.ActivityUserBinding;
import br.facens.helpcity.ui.fragments.user.LoginFragment;
import br.facens.helpcity.utils.AppFunction;

public class UserActivity extends AppCompatActivity {

    private ActivityUserBinding binding;
    private AppFunction appFunction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        appFunction = AppFunction.getInstance();

        appFunction.replaceFragment(
                getSupportFragmentManager(),
                new LoginFragment(),
                null,
                R.id.fmlUserMain,
                "DE"
        );

    }
}