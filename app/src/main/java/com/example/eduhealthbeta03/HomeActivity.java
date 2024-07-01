package com.example.eduhealthbeta03;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class HomeActivity extends AppCompatActivity {


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        LinearLayout btn_tentang = findViewById(R.id.btn_tentang);
        LinearLayout btn_video = findViewById(R.id.btn_video);
        LinearLayout btn_rekam_jejak = findViewById(R.id.btn_rekam_jejak);
        LinearLayout btn_qna = findViewById(R.id.btn_qna);

        btn_qna.setOnClickListener(view -> {
            Intent i =new Intent(HomeActivity.this, QnaActivity.class);
            startActivity(i);
        });

        btn_tentang.setOnClickListener(view -> {
            Intent i =new Intent(HomeActivity.this, TentangActivity.class);
            startActivity(i);
        });
        btn_video.setOnClickListener(view -> {
            Intent i =new Intent(HomeActivity.this, VideoActivity.class);
            startActivity(i);
        });
        btn_rekam_jejak.setOnClickListener(view -> {
            Intent i =new Intent(HomeActivity.this, RekamActivity.class);
            startActivity(i);
        });
    }
}
