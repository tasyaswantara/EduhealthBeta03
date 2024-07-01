package com.example.eduhealthbeta03;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Objects;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    private final ArrayList<Video> listVideo;
    public VideoAdapter(ArrayList<Video> listVideo) {
        this.listVideo = listVideo;
    }



    @NonNull
    @Override
    public VideoAdapter.VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_video,parent,false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.VideoViewHolder holder, int position) {
        holder.title.setText(listVideo.get(position).getTitle());
        Video video = listVideo.get(position);
        String videoId = video.getVideo().split("v=")[1];
        String thumbnailUrl = "https://img.youtube.com/vi/" + videoId + "/hqdefault.jpg";

        Glide.with(holder.itemView.getContext())
                .load(thumbnailUrl)
                .into(holder.imgVideo);

        holder.imgVideo.setOnClickListener(view -> {
            String youtubeUrl = video.getVideo();
            Uri uri = Uri.parse(youtubeUrl);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            holder.itemView.getContext().startActivity(intent);
        });

        holder.btn_edit.setOnClickListener(view -> showDialog(holder.itemView.getContext(), "Simpan", false, video));


        holder.btn_delete.setOnClickListener(view -> showDialog(holder.itemView.getContext(), "Hapus", true, video));


    }

    @Override
    public int getItemCount() {
        return (listVideo!= null) ? listVideo.size() : 0;
    }
    private void showDialog(Context context, String buttonText, boolean disableEditText, Video video) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.popup_form);

        EditText editTextLink = dialog.findViewById(R.id.edit_link);
        EditText editTextTitle = dialog.findViewById(R.id.edit_judul);
        TextView btnConfirm = dialog.findViewById(R.id.btn_confirm);
        ImageView btnClose = dialog.findViewById(R.id.btn_close);

        btnConfirm.setText(buttonText);
        editTextLink.setText(video.getVideo());
        editTextTitle.setText(video.getTitle());

        editTextLink.setEnabled(!disableEditText);
        editTextTitle.setEnabled(!disableEditText);

        btnClose.setOnClickListener(v -> dialog.dismiss());

        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
    public static class VideoViewHolder extends RecyclerView.ViewHolder{
        private final TextView title;
        private final ImageView imgVideo;
        private final ImageView btn_edit;
        private final ImageView btn_delete;

        public VideoViewHolder(View view){
            super(view);
            title=view.findViewById(R.id.txt_title);
            imgVideo=view.findViewById(R.id.youtube_thumbnail);
            btn_edit=view.findViewById(R.id.btn_edit);
            btn_delete=view.findViewById(R.id.btn_delete);


        }
    }

}
