package com.example.eduhealthbeta03;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

public class VideoActivity extends AppCompatActivity {
    private ArrayList<Video> videoArrayList;
    private ImageView btn_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_video);
        getWindow().setStatusBarColor(ContextCompat.getColor(VideoActivity.this, R.color.white));
        getWindow().setNavigationBarColor(ContextCompat.getColor(VideoActivity.this,R.color.white));



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getData();
        RecyclerView recyclerView = findViewById(R.id.recycleview);
        VideoAdapter videoAdapter = new VideoAdapter(videoArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(VideoActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(videoAdapter);


        ImageView btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(view -> {
            Intent i= new Intent(VideoActivity.this, HomeActivity.class);
            startActivity(i);


        });

        ImageView fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Dialog dialog =new Dialog(VideoActivity.this);
            dialog.setContentView(R.layout.popup_form);

            btn_close= dialog.findViewById(R.id.btn_close);
            btn_close.setOnClickListener(view1 -> dialog.dismiss());
            Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();

        });


    }
    public void getData(){
        videoArrayList = new ArrayList<>();

//      link harus ada "v=" jika tidak ada jadi bug
        videoArrayList.add(new Video("https://www.youtube.com/watch?v=00JysgLq1cE","Ini judulku bang"));
        videoArrayList.add(new Video("https://www.youtube.com/watch?v=bbg5WC-Br28","Nessie juge"));
        videoArrayList.add(new Video("https://www.youtube.com/watch?v=2wA_b6YHjqQ","Sheesh Sheesh"));
        videoArrayList.add(new Video("https://www.youtube.com/watch?v=bbg5WC-Br28","Nessie juge"));
    }





}