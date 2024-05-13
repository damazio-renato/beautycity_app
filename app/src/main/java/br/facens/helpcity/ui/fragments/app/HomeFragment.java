package br.facens.helpcity.ui.fragments.app;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import br.facens.helpcity.R;
import br.facens.helpcity.adapters.recyclerviews.AdapterRequest;
import br.facens.helpcity.databinding.FragmentHomeBinding;
import br.facens.helpcity.models.Request;
import br.facens.helpcity.ui.activities.RequestActivity;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        binding.incTitleBar.ttvLeftOne.setText("Sair");
        binding.incTitleBar.ttvRightOne.setText("Novo");
        binding.incTitleBar.ttvTitleBar.setText("Help City");

        binding.incTitleBar.ttvLeftOne.setOnClickListener(v -> {
            getActivity().finish();
        });

        binding.incTitleBar.ttvRightOne.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), RequestActivity.class));
        });

        listAll();

        return binding.getRoot();
    }

    private void listAll(){
        ArrayList<Request> requests = new ArrayList<>();
        requests.add(
                new Request(
                        "Buracos nas Ruas",
                        "A rua das Flores esta cheia de buracos, dificultando a locomoção de veículos e pedestres. Alguns buracos são tão grandes que representam perigo para os motoristas.",
                        "12/05/2024 16:45:10"
                )
        );
        requests.add(
                new Request(
                        "Postes sem Luz",
                        "Muitos postes de luz do bairro Jardim Primavera estão sem iluminação, tornando as ruas perigosas para locomoção a noite.",
                        "12/05/2024 16:45:10"
                )
        );
        AdapterRequest adapter = new AdapterRequest(getActivity(), requests);
        adapter.notifyDataSetChanged();
        binding.rcvRequets.setAdapter(adapter);
    }
}