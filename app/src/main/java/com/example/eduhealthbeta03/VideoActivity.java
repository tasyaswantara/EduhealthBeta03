package com.example.eduhealthbeta03;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VideoActivity extends AppCompatActivity {
     private RecyclerView recyclerView;
     private VideoAdapter videoAdapter;
     private ArrayList<Video> videoArrayList;
     private ImageView btn_back;
     private ImageView fab;
     private ImageView btn_close;
     Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_video);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getData();
        recyclerView = findViewById(R.id.recycleview);
        videoAdapter= new VideoAdapter(videoArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(VideoActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(videoAdapter);




        btn_back= findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(VideoActivity.this, HomeActivity.class);
                startActivity(i);


            }
        });

        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog =new Dialog(VideoActivity.this);
                dialog.setContentView(R.layout.popup_form);

                btn_close= dialog.findViewById(R.id.btn_close);
                btn_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });


    }
    public void getData(){
        videoArrayList = new ArrayList<>();
        videoArrayList.add(new Video("https://www.youtube.com/watch?v=00JysgLq1cE","Ini judulku bang"));
        videoArrayList.add(new Video("https://www.youtube.com/watch?v=bbg5WC-Br28","Nessie juge"));
        videoArrayList.add(new Video("https://www.youtube.com/watch?v=2wA_b6YHjqQ","Sheesh Sheesh"));
        videoArrayList.add(new Video("https://www.youtube.com/watch?v=bbg5WC-Br28","Nessie juge"));
    }





}