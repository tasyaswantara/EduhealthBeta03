package com.example.eduhealthbeta03;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.eduhealthbeta03.R;
import com.example.eduhealthbeta03.TentangActivity;

public class HomeActivity extends AppCompatActivity {
    private LinearLayout btn_tentang;
    private LinearLayout btn_video;
    private LinearLayout btn_rekam_jejak;


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
        btn_tentang=findViewById(R.id.btn_tentang);
        btn_video=findViewById(R.id.btn_video);
        btn_rekam_jejak=findViewById(R.id.btn_rekam_jejak);

        btn_tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(HomeActivity.this, TentangActivity.class);
                startActivity(i);
            }
        });
        btn_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(HomeActivity.this, VideoActivity.class);
                startActivity(i);
            }
        });
        btn_rekam_jejak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(HomeActivity.this, RekamActivity.class);
                startActivity(i);
            }
        });
    }
}