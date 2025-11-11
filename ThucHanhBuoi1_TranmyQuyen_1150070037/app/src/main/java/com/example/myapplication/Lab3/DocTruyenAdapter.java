package com.example.myapplication.Lab3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class DocTruyenAdapter extends RecyclerView.Adapter<DocTruyenAdapter.DocTruyenViewHolder> {

    private String[] storyTitles;
    private String[] storyContents;

    public DocTruyenAdapter(String[] storyTitles, String[] storyContents) {
        this.storyTitles = storyTitles;
        this.storyContents = storyContents;
    }

    @NonNull
    @Override
    public DocTruyenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_doc_truyen, parent, false);
        return new DocTruyenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DocTruyenViewHolder holder, int position) {
        holder.tvTitle.setText(storyTitles[position]);
        holder.tvContent.setText(storyContents[position]);
    }

    @Override
    public int getItemCount() {
        return storyTitles.length;
    }

    static class DocTruyenViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvContent;

        DocTruyenViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvStoryTitle);
            tvContent = itemView.findViewById(R.id.tvStoryContent);
        }
    }
}
