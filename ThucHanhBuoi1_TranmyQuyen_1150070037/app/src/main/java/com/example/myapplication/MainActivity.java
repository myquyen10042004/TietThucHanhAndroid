package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Lab1.BaiTap1Lab1Activity;
import com.example.myapplication.Lab1.BaiTap2Lab1Activity;
import com.example.myapplication.Lab1.BaiTap3Lab1Activity;
import com.example.myapplication.Lab2.BaiTap1Lab2Activity;
import com.example.myapplication.Lab2.BaiTap2Lab2Activity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        View btnLab1 = findViewById(R.id.btnLab1);
        View btnLab2 = findViewById(R.id.btnLab2);
        View btnLab3 = findViewById(R.id.btnLab3);
        View btnLab4 = findViewById(R.id.btnLab4);
        View btnLab5 = findViewById(R.id.btnLab5);

        btnLab1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BaiTap1Lab1Activity.class);
            startActivity(intent);
        });
        btnLab2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BaiTap2Lab1Activity.class);
            startActivity(intent);
        });
        btnLab3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BaiTap3Lab1Activity.class);
            startActivity(intent);
        });
        btnLab4.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BaiTap1Lab2Activity.class);
            startActivity(intent);
        });
        btnLab5.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BaiTap2Lab2Activity.class);
            startActivity(intent);
        });


    }
}