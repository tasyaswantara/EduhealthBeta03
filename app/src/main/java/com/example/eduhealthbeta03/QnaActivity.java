
package com.example.eduhealthbeta03;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowInsetsController;
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

public class QnaActivity extends AppCompatActivity {

    private ArrayList<Qna> qnaArrayList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_qna);

        getWindow().setStatusBarColor(ContextCompat.getColor(QnaActivity.this, R.color.white));
        getWindow().setNavigationBarColor(ContextCompat.getColor(QnaActivity.this,R.color.white));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            getWindow().setDecorFitsSystemWindows(false);
            WindowInsetsController controller = getWindow().getInsetsController();
            if (controller != null) {
                controller.setSystemBarsAppearance(
                        WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                        WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS
                );

            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getData();
        RecyclerView qna_recyclerView = findViewById(R.id.qna_recyclerview);
        QnaAdapter qnaAdapter = new QnaAdapter(qnaArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(QnaActivity.this);
        qna_recyclerView.setLayoutManager(layoutManager);
        qna_recyclerView.setAdapter(qnaAdapter);

        ImageView btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(view -> {
            Intent i= new Intent(QnaActivity.this, HomeActivity.class);
            startActivity(i);


        });

    }
    public void getData(){
        qnaArrayList = new ArrayList<>();
        qnaArrayList.add(new Qna("Ini merupakan contoh pertanyaan tentang aplikasi ini ?","Ini merupakan contoh Jawaban tentang aplikasi ini. Gatau benar atau tidak yang penting dijawab saja ya."));
        qnaArrayList.add(new Qna("Ini merupakan contoh pertanyaan kedua","Ini merupakan contoh Jawaban tentang aplikasi ini. Gatau benar atau tidak yang penting dijawab saja ya."));
        qnaArrayList.add(new Qna("Ini merupakan contoh pertanyaan ketiga","Ini merupakan contoh Jawaban tentang aplikasi ini. Gatau benar atau tidak yang penting dijawab saja ya."));
        qnaArrayList.add(new Qna("Ini merupakan contoh pertanyaan keempat","Ini merupakan contoh Jawaban tentang aplikasi ini. Gatau benar atau tidak yang penting dijawab saja ya."));
        qnaArrayList.add(new Qna("Ini merupakan contoh pertanyaan kelima","Ini merupakan contoh Jawaban tentang aplikasi ini. Gatau benar atau tidak yang penting dijawab saja ya."));
        qnaArrayList.add(new Qna("Ini merupakan contoh pertanyaan keenam bang","Ini merupakan contoh Jawaban tentang aplikasi ini. Gatau benar atau tidak yang penting dijawab saja ya."));


    }

}