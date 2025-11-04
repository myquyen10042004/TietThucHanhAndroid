package com.example.myapplication.Lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class BaiTap1Lab1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai_tap1_lab1);
        EditText edtSo1, edtSo2;
        TextView tvKetQua;
        Button btnCong, btnTru, btnNhan, btnChia, btnChiaDu;

        edtSo1 = findViewById(R.id.edtSo1);
        edtSo2 = findViewById(R.id.edtSo2);
        tvKetQua = findViewById(R.id.tvKetQua);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        btnChiaDu = findViewById(R.id.btnChiaDu);

        View.OnClickListener phepToan = v -> {
            // kiểm tra nhập rỗng
            if (edtSo1.getText().toString().isEmpty() || edtSo2.getText().toString().isEmpty()) {
                tvKetQua.setText("Vui lòng nhập đủ hai số!");
                return;
            }

            double a = Double.parseDouble(edtSo1.getText().toString());
            double b = Double.parseDouble(edtSo2.getText().toString());
            double kq = 0;


            if (v.getId() == R.id.btnCong) {
                kq = a + b;
            }
            else if (v.getId() == R.id.btnTru) {
                kq = a - b;
            }
            else if (v.getId() == R.id.btnNhan) {
                kq = a * b;
            }
            else if (v.getId() == R.id.btnChia) {
                if (b != 0)
                    kq = a / b;
                else {
                    tvKetQua.setText("Không thể chia cho 0!");
                    return;
                }
            }
            else if (v.getId() == R.id.btnChiaDu) {
                if (b != 0)
                    kq = a % b;
                else {
                    tvKetQua.setText("Không thể chia cho 0!");
                    return;
                }
            }

            tvKetQua.setText("Kết quả: " + kq);
        };
        btnCong.setOnClickListener(phepToan);
        btnTru.setOnClickListener(phepToan);
        btnNhan.setOnClickListener(phepToan);
        btnChia.setOnClickListener(phepToan);
        btnChiaDu.setOnClickListener(phepToan);

    }
}