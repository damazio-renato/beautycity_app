package br.facens.helpcity.ui.activities;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.facens.helpcity.R;
import br.facens.helpcity.databinding.ActivityRequestBinding;

public class RequestActivity extends AppCompatActivity {

    private ActivityRequestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRequestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.incTitleBar.ttvLeftOne.setText("Voltar");
        binding.incTitleBar.ttvTitleBar.setText("Criar Reclamação");

        binding.incTitleBar.ttvRightOne.setVisibility(View.GONE);

        binding.incTitleBar.ttvLeftOne.setOnClickListener(v -> {
            finish();
        });

        binding.btnSend.setOnClickListener(v -> {
            showDialogInfoMessage("Obrigado!");
        });

    }

    public void showDialogInfoMessage(String title) {
        Dialog dialog = new Dialog(this, android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
        dialog.setContentView(R.layout.dialog_info_message);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(150, 0, 0, 0)));
        dialog.setCancelable(false);
        TextView ttvTitle = dialog.findViewById(R.id.ttvTitleDialogInfoMessage);
        ttvTitle.setText(title);
        dialog.findViewById(R.id.btnOk).setOnClickListener(v -> {
            dialog.dismiss();
        });
        dialog.show();
    }
}