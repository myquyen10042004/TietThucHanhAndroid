package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Lab1.BaiTap1Lab1Activity;
import com.example.myapplication.Lab1.BaiTap2Lab1Activity;
import com.example.myapplication.Lab1.BaiTap3Lab1Activity;
import com.example.myapplication.Lab10_11.M001MenuActivity;
import com.example.myapplication.Lab13_14.m000_frg_login.MainActivityBuoi5;
import com.example.myapplication.Lab2.BaiTap1Lab2Activity;
import com.example.myapplication.Lab2.BaiTap2Lab2Activity;
import com.example.myapplication.Lab3.TruyenCuoiActivity;
import com.example.myapplication.Lab6.DoiDoDaiActivity;
import com.example.myapplication.Lab6.DoiTienTeActivity;

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
        View btnLab7 = findViewById(R.id.btnLab7);
        View btnLab9 = findViewById(R.id.btnLab9);
        View btnLab10 = findViewById(R.id.btnLab10);
        View btnLab11 = findViewById(R.id.btnLab11);
        View btnLab12 = findViewById(R.id.btnLab12);
        View btnLab13_14 = findViewById(R.id.btnLab13_14);
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
        btnLab7.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TruyenCuoiActivity.class);
            startActivity(intent);
        });
        btnLab9.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DoiTienTeActivity.class);
            startActivity(intent);
        });

        btnLab10.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DoiDoDaiActivity.class);
            startActivity(intent);
        });
        btnLab11.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TruyenCuoiActivity.class);
            startActivity(intent);
        });
        btnLab12.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, M001MenuActivity.class);
            startActivity(intent);
        });
        btnLab13_14.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivityBuoi5.class);
            startActivity(intent);
        });
    }
}