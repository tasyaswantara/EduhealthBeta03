package com.example.eduhealthbeta03;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RekamAdapter extends RecyclerView.Adapter<RekamAdapter.RekamViewHolder> {
    private ArrayList<Rekam> listRekam;
    private boolean isEditMode = false;

    public RekamAdapter(ArrayList<Rekam> listRekam) {
        this.listRekam = listRekam;
    }

    @NonNull
    @Override
    public RekamAdapter.RekamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_rekam, parent, false);
        return new RekamAdapter.RekamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RekamAdapter.RekamViewHolder holder, int position) {
        Rekam rekam = listRekam.get(position);
        holder.name.setText(rekam.getName());

        holder.name.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), RekamJejakActivity.class);
            intent.putExtra("isEditMode", isEditMode);
            view.getContext().startActivity(intent);
        });

        holder.btn_edit.setOnClickListener(view -> {
            isEditMode = true;
            Intent intent = new Intent(view.getContext(), RekamJejakActivity.class);
            intent.putExtra("isEditMode", isEditMode);
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return (listRekam != null) ? listRekam.size() : 0;
    }

    public static class RekamViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private ImageView btn_edit, btn_delete;

        public RekamViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.txt_name);
            btn_edit = view.findViewById(R.id.btn_edit);
            btn_delete = view.findViewById(R.id.btn_delete);
        }
    }
}
