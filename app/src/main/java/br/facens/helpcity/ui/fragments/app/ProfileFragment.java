package br.facens.helpcity.ui.fragments.app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.facens.helpcity.R;
import br.facens.helpcity.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);

        binding.incTitleBar.ttvTitleBar.setText("Perfil");
        binding.incTitleBar.ttvLeftOne.setText("");
        binding.incTitleBar.ttvRightOne.setText("");

        return binding.getRoot();
    }
}