package com.example.eduhealthbeta03;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class RekamJejakActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView opsi1, opsi2, opsi3;
    private ColorStateList def;
    private boolean isEditMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rekam_jejak);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        opsi1 = findViewById(R.id.rekam_opsi1);
        opsi2 = findViewById(R.id.rekam_opsi2);
        opsi3 = findViewById(R.id.rekam_opsi3);

        opsi1.setOnClickListener(this);
        opsi2.setOnClickListener(this);
        opsi3.setOnClickListener(this);
        def = opsi2.getTextColors();

        updateSelection(new RekamJejakStatusGizi(), opsi1);

        findViewById(R.id.btn_back).setOnClickListener(view -> {
            startActivity(new Intent(RekamJejakActivity.this, RekamActivity.class));
        });
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        Fragment selectedFragment = null;
        TextView selectedOpsi = null;

        if (viewId == R.id.rekam_opsi1) {
            selectedFragment = new RekamJejakStatusGizi();
            selectedOpsi = opsi1;
        } else if (viewId == R.id.rekam_opsi2) {
            selectedFragment = new RekamJejakSkriningAnemia();
            selectedOpsi = opsi2;
        } else if (viewId == R.id.rekam_opsi3) {
            selectedFragment = new RekamJejakPantauSakit();
            selectedOpsi = opsi3;
        }

        if (selectedFragment != null && selectedOpsi != null) {
            updateSelection(selectedFragment, selectedOpsi);
        }
    }

    private void updateSelection(Fragment fragment, TextView selectedOpsi) {
        replaceFragment(fragment);

        opsi1.setTextColor(def);
        opsi1.setBackground(getResources().getDrawable(R.drawable.input_shape));
        opsi2.setTextColor(def);
        opsi2.setBackground(getResources().getDrawable(R.drawable.input_shape));
        opsi3.setTextColor(def);
        opsi3.setBackground(getResources().getDrawable(R.drawable.input_shape));

        selectedOpsi.setTextColor(Color.BLACK);
        selectedOpsi.setBackground(getResources().getDrawable(R.drawable.background_blue));
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.rekamJejak_section3, fragment);
        fragmentTransaction.commit();
    }
}
