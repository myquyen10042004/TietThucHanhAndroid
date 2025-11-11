package com.example.myapplication.Lab3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;

public class ChuDeAdapter extends RecyclerView.Adapter<ChuDeAdapter.ChuDeViewHolder> {

    private String[] topicNames;
    private int[] topicImages;
    private OnTopicClickListener listener;


    public interface OnTopicClickListener {
        void onTopicClick(int position);
    }

    public ChuDeAdapter(String[] topicNames, int[] topicImages, OnTopicClickListener listener) {
        this.topicNames = topicNames;
        this.topicImages = topicImages;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ChuDeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chu_de, parent, false);
        return new ChuDeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChuDeViewHolder holder, int position) {
        holder.tvTopicName.setText(topicNames[position]);
        holder.imgTopic.setImageResource(topicImages[position]);

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) listener.onTopicClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return topicNames.length;
    }

    static class ChuDeViewHolder extends RecyclerView.ViewHolder {
        ImageView imgTopic;
        TextView tvTopicName;

        ChuDeViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTopic = itemView.findViewById(R.id.imgTopic);
            tvTopicName = itemView.findViewById(R.id.tvTopicName);
        }
    }
}
