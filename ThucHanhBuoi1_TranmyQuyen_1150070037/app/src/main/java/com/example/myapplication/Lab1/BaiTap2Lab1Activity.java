package com.example.myapplication.Lab1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.Random;

public class BaiTap2Lab1Activity extends AppCompatActivity {
    TextView tvNumber;
    Button btnRandom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai_tap2_lab1);

            tvNumber = findViewById(R.id.tvNumber);
            btnRandom = findViewById(R.id.btnRandom);

            Random random = new Random();

            btnRandom.setOnClickListener(v -> {
                // Tạo số ngẫu nhiên từ 0 đến 99
                int soNgauNhien = random.nextInt(100);
                tvNumber.setText(String.format("%02d", soNgauNhien));
            });
        }
    }