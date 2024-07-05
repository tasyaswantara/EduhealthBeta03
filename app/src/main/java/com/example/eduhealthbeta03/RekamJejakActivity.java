package com.example.eduhealthbeta03;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class RekamJejakActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView opsi1, opsi2, opsi3;
    private ColorStateList def;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rekam_jejak);
        getWindow().setStatusBarColor(ContextCompat.getColor(RekamJejakActivity.this, R.color.white));
        getWindow().setNavigationBarColor(ContextCompat.getColor(RekamJejakActivity.this,R.color.white));

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

        viewPager = findViewById(R.id.viewPager);
        FragmentStateAdapter pagerAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        // Add page change callback
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                updateTabSelection(position);
            }
        });

        findViewById(R.id.btn_back).setOnClickListener(view -> startActivity(new Intent(RekamJejakActivity.this, RekamActivity.class)));

        // Set default selection
        viewPager.setCurrentItem(0);
        updateTabSelection(0);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        if (viewId == R.id.rekam_opsi1) {
            viewPager.setCurrentItem(0);
        } else if (viewId == R.id.rekam_opsi2) {
            viewPager.setCurrentItem(1);
        } else if (viewId == R.id.rekam_opsi3) {
            viewPager.setCurrentItem(2);
        }
    }


    private void updateTabSelection(int position) {
        opsi1.setTextColor(def);
        opsi1.setBackground(ContextCompat.getDrawable(this, R.drawable.input_shape));
        opsi2.setTextColor(def);
        opsi2.setBackground(ContextCompat.getDrawable(this, R.drawable.input_shape));
        opsi3.setTextColor(def);
        opsi3.setBackground(ContextCompat.getDrawable(this, R.drawable.input_shape));

        TextView selectedOpsi = null;

        if (position == 0) {
            selectedOpsi = opsi1;
        } else if (position == 1) {
            selectedOpsi = opsi2;
        } else if (position == 2) {
            selectedOpsi = opsi3;
        }

        if (selectedOpsi != null) {
            selectedOpsi.setTextColor(Color.BLACK);
            selectedOpsi.setBackground(ContextCompat.getDrawable(this, R.drawable.background_blue));
        }
    }

    private static class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        private final List<Fragment> fragmentList = new ArrayList<>();

        public ScreenSlidePagerAdapter(@NonNull AppCompatActivity fragmentActivity) {
            super(fragmentActivity);
            fragmentList.add(new RekamJejakStatusGizi());
            fragmentList.add(new RekamJejakSkriningAnemia());
            fragmentList.add(new RekamJejakPantauSakit());
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getItemCount() {
            return fragmentList.size();
        }
    }
}
