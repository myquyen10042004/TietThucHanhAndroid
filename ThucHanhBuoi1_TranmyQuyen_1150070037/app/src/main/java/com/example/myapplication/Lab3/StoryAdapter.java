package com.example.myapplication.Lab3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder> {

    private String[] stories;
    private OnItemClickListener listener;


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public StoryAdapter(String[] stories, OnItemClickListener listener) {
        this.stories = stories;
        this.listener = listener;
    }

    @NonNull
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_danh_sach_truyen, parent, false);
        return new StoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder holder, int position) {
        holder.tvStoryTitle.setText(stories[position]);
        holder.itemView.setOnClickListener(v -> listener.onItemClick(position));
    }

    @Override
    public int getItemCount() {
        return stories.length;
    }

    static class StoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvStoryTitle;
        ImageView imgStoryIcon;

        StoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvStoryTitle = itemView.findViewById(R.id.tvStoryTitle);
            imgStoryIcon = itemView.findViewById(R.id.imgStoryIcon);
        }
    }
}
