package com.example.myapplication.Lab3;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class M001ScreenChuDe extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_m001_screen_chu_de, container, false);

        ImageView imgBack = view.findViewById(R.id.imgBack);
        Switch switchRotate = view.findViewById(R.id.switchRotate);

        RecyclerView rvTopics = view.findViewById(R.id.rvTopics);
        rvTopics.setLayoutManager(new LinearLayoutManager(getContext()));

        imgBack.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
            getActivity().finish();
        });

        switchRotate.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {

                getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
            } else {

                getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
        });


        String[] topicNames = {"Chú chó vui nhộn", "Cách cách", "Mèo râu ria"};
        int[] topicImages = {R.drawable.chuchovuinhon, R.drawable.cachcach, R.drawable.meorauria};


        ChuDeAdapter adapter = new ChuDeAdapter(topicNames, topicImages, position -> {
            String selectedTopic = topicNames[position];


            ((TruyenCuoiActivity) getActivity()).gotoM002Screen(selectedTopic);
        });

        rvTopics.setAdapter(adapter);
        return view;
    }
}
