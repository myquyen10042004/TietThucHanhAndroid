package com.example.myapplication.Lab10_11;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class M002DetailActivity extends AppCompatActivity {
    ImageView imgCung, btnBack;
    TextView tvTenCung, tvMoTa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_m002_detail);
        anhXaView();
        nhanDuLieu();
        xuLySuKien();
        }

    private void anhXaView(){
        imgCung = findViewById(R.id.imgCung);
        btnBack = findViewById(R.id.btnBack);
        tvTenCung = findViewById(R.id.tvTenCung);
        tvMoTa = findViewById(R.id.tvMoTa);
    }
    private void xuLySuKien(){
        btnBack.setOnClickListener(v-> finish());
    }

    private void nhanDuLieu() {
        Intent intent = getIntent();

        String ten = intent.getStringExtra("tenCung");
        String moTa = intent.getStringExtra("moTa");
        int hinh = intent.getIntExtra("hinh", 0);
        tvTenCung.setText(ten);
        tvMoTa.setText(moTa);
        if (hinh != 0) imgCung.setImageResource(hinh);
    }
}