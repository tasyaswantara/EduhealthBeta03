package com.example.eduhealthbeta03;

import android.animation.LayoutTransition;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QnaAdapter extends RecyclerView.Adapter<QnaAdapter.QnaViewHolder> {
    private final ArrayList<Qna> listQna;

    public QnaAdapter(ArrayList<Qna> listQna) {
        this.listQna = listQna;
    }

    @NonNull
    @Override
    public QnaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_qna, parent, false);
        return new QnaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QnaViewHolder holder, int position) {
        Qna qna = listQna.get(position);
        holder.question.setText(qna.getQuestion());
        holder.answer.setText(qna.getAnswer());
        holder.layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        holder.layout.setOnClickListener(v -> {
            boolean isVisible = holder.answer.getVisibility() == View.VISIBLE;
            TransitionManager.beginDelayedTransition(holder.layout, new AutoTransition());
            holder.answer.setVisibility(isVisible ? View.GONE : View.VISIBLE);
        });
    }

    @Override
    public int getItemCount() {
        return listQna != null ? listQna.size() : 0;
    }

    public static class QnaViewHolder extends RecyclerView.ViewHolder {
        private final TextView question;
        private final TextView answer;
        private final LinearLayout layout;

        public QnaViewHolder(View view) {
            super(view);
            question = view.findViewById(R.id.txt_question);
            answer = view.findViewById(R.id.detail);
            layout = view.findViewById(R.id.qna_layout);

            // Ensure the initial visibility state of the answer is gone
            answer.setVisibility(View.GONE);
        }
    }
}
