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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class M002ScreenDanhSachTruyen extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_m002_screen_danh_sach_truyen, container, false);


        RecyclerView rvStories = view.findViewById(R.id.rvStories);
        ImageView imgBack = view.findViewById(R.id.imgBack);
        TextView tvTopicTitle = view.findViewById(R.id.tvTopicTitle);

        rvStories.setLayoutManager(new LinearLayoutManager(getContext()));


        String topicName = getArguments() != null ? getArguments().getString("TOPIC_NAME") : "";
        tvTopicTitle.setText(topicName);


        imgBack.setOnClickListener(v -> {
            ((TruyenCuoiActivity) getActivity()).backToM001Screen();
        });


        String[] stories;
        String[] storyContents;

        switch (topicName) {
            case "Chú chó vui nhộn":
                stories = new String[]{"Cún con thông minh", "Cún lười học", "Cún và mèo"};
                storyContents = new String[]{
                        "Lúc bé, nghĩ học là chuyện lạ. Lớn lên mới biết, học là cực hình.",
                        "Cún lười học nên bị mèo trêu suốt, cuối cùng lại giỏi nhất lớp.",
                        "Cún và mèo luôn cãi nhau, nhưng cuối cùng lại là bạn tốt."
                };
                break;

            case "Cách cách":
                stories = new String[]{"Cách cư xử lạ", "Bí mật Cách cách", "Cách cách đi học"};
                storyContents = new String[]{
                        "Cách cách cư xử khiến ai cũng bất ngờ.",
                        "Bí mật của Cách cách là gì? Hãy cùng khám phá.",
                        "Cách cách đi học, cả lớp cười nghiêng ngả."
                };
                break;

            case "Mèo râu ria":
                stories = new String[]{"Mèo bắt cá", "Mèo nghịch ngợm", "Râu ria dài"};
                storyContents = new String[]{
                        "Mèo bắt cá nhưng lại sợ ướt chân.",
                        "Mèo nghịch ngợm khiến cả nhà rối tung.",
                        "Râu ria dài giúp mèo luôn tự tin!"
                };
                break;

            default:
                stories = new String[]{"Không có truyện nào"};
                storyContents = new String[]{"Không có nội dung"};
        }

        // Khởi tạo Adapter và xử lý khi click vào 1 truyện
        StoryAdapter adapter = new StoryAdapter(stories, position -> {
            Bundle bundle = new Bundle();
            bundle.putString("TOPIC_NAME", topicName);
            bundle.putInt("STORY_INDEX", position);
            bundle.putStringArray("STORY_TITLES", stories);
            bundle.putStringArray("STORY_CONTENTS", storyContents);

            M003ScreenDocTruyen frg = new M003ScreenDocTruyen();
            frg.setArguments(bundle);

            ((TruyenCuoiActivity) getActivity()).showFrg(frg);
        });

        rvStories.setAdapter(adapter);

        return view;
    }
}
