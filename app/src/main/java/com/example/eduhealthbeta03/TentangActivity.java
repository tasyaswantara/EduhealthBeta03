package com.example.eduhealthbeta03;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TentangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tentang);
        getWindow().setStatusBarColor(ContextCompat.getColor(TentangActivity.this, R.color.white));
        getWindow().setNavigationBarColor(ContextCompat.getColor(TentangActivity.this,R.color.white));



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(view -> {
            Intent i= new Intent(TentangActivity.this, HomeActivity.class);
            startActivity(i);


        });
    }
}