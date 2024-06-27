package com.example.eduhealthbeta03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RekamActivity extends AppCompatActivity {
    private RecyclerView rekam_recyclerView;
    private RekamAdapter rekamAdapter;
    private ArrayList<Rekam> rekamArrayList;
    private ImageView btn_back,fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rekam);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getData();
        rekam_recyclerView = findViewById(R.id.rekam_recyclerview);
        rekamAdapter= new RekamAdapter(rekamArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RekamActivity.this);
        rekam_recyclerView.setLayoutManager(layoutManager);
        rekam_recyclerView.setAdapter(rekamAdapter);

        btn_back= findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(RekamActivity.this, HomeActivity.class);
                startActivity(i);


            }
        });
        fab= findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(RekamActivity.this, RekamJejakActivity.class);
                startActivity(i);


            }
        });
    }
    public void getData(){
        rekamArrayList = new ArrayList<>();
        rekamArrayList.add(new Rekam("Tasya"));
        rekamArrayList.add(new Rekam("Aldi"));
        rekamArrayList.add(new Rekam("Kenan"));
        rekamArrayList.add(new Rekam("Meong"));
        rekamArrayList.add(new Rekam("Kiw"));
        rekamArrayList.add(new Rekam("Tasya"));
        rekamArrayList.add(new Rekam("Aldi"));
        rekamArrayList.add(new Rekam("Kenan"));
        rekamArrayList.add(new Rekam("Meong"));
        rekamArrayList.add(new Rekam("Kiw"));
        rekamArrayList.add(new Rekam("Tasya"));
        rekamArrayList.add(new Rekam("Aldi"));
        rekamArrayList.add(new Rekam("Kenan"));
        rekamArrayList.add(new Rekam("Meong"));
        rekamArrayList.add(new Rekam("Kiw"));

    }
}