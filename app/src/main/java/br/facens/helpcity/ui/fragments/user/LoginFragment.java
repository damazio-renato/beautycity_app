package br.facens.helpcity.ui.fragments.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import br.facens.helpcity.R;
import br.facens.helpcity.databinding.FragmentLoginBinding;
import br.facens.helpcity.ui.activities.AppActivity;
import br.facens.helpcity.utils.AppFunction;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private AppFunction appFunction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);

        appFunction = AppFunction.getInstance();

        binding.btnEnter.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), AppActivity.class));
            getActivity().finish();
        });

        binding.ttvRegister.setOnClickListener(v -> {
            appFunction.replaceFragment(
                    getActivity().getSupportFragmentManager(),
                    new RegisterFragment(),
                    null,
                    R.id.fmlUserMain,
                    "DE"
            );
        });

        return binding.getRoot();
    }
}