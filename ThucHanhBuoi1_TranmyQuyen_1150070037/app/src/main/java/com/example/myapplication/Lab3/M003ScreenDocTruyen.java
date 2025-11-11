package com.example.myapplication.Lab3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myapplication.R;

public class M003ScreenDocTruyen extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_m003_screen_doc_truyen, container, false);

        ImageView imgBack = view.findViewById(R.id.imgBack);
        TextView tvTopicTitle = view.findViewById(R.id.tvTopicTitle);
        ViewPager2 viewPager = view.findViewById(R.id.viewPager);


        Bundle bundle = getArguments();
        if (bundle == null) return view;

        String topicName = bundle.getString("TOPIC_NAME", "Chủ đề");
        int currentIndex = bundle.getInt("STORY_INDEX", 0);
        String[] storyTitles = bundle.getStringArray("STORY_TITLES");
        String[] storyContents = bundle.getStringArray("STORY_CONTENTS");

        tvTopicTitle.setText(topicName);


        DocTruyenAdapter adapter = new DocTruyenAdapter(storyTitles, storyContents);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(currentIndex, false);


        imgBack.setOnClickListener(v -> {
            ((TruyenCuoiActivity) getActivity()).backToM002Screen();
        });

        return view;
    }
}
