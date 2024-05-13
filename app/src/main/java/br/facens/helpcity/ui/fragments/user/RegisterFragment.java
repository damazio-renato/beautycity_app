package br.facens.helpcity.ui.fragments.user;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import br.facens.helpcity.R;
import br.facens.helpcity.databinding.FragmentRegisterBinding;
import br.facens.helpcity.ui.activities.AppActivity;
import br.facens.helpcity.utils.AppFunction;

public class RegisterFragment extends Fragment {

    private FragmentRegisterBinding binding;
    private AppFunction appFunction;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        
        appFunction = AppFunction.getInstance();

        binding.ttvEnter.setOnClickListener(v -> {
            appFunction.replaceFragment(
                    getActivity().getSupportFragmentManager(),
                    new LoginFragment(),
                    null,
                    R.id.fmlUserMain,
                    "ED"
            );
        });

        binding.btnRegister.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
        });
        
        return binding.getRoot();
    }
}