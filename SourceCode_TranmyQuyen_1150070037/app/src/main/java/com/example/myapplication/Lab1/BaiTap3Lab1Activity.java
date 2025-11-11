package com.example.myapplication.Lab1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class BaiTap3Lab1Activity extends AppCompatActivity {

    EditText edtPhone, edtMessage;
    Button btnCall, btnSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai_tap3_lab1);
        edtPhone = findViewById(R.id.edtPhone);
        edtMessage = findViewById(R.id.edtMessage);
        btnCall = findViewById(R.id.btnCall);
        btnSms = findViewById(R.id.btnSms);

        //  GỌI ĐIỆN
        btnCall.setOnClickListener(v -> {
            String phone = edtPhone.getText().toString().trim();
            if (phone.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập số điện thoại!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Sử dụng ACTION_DIAL để mở app gọi (không cần quyền CALL_PHONE)
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
            startActivity(intent);
        });

        //  GỬI TIN NHẮN
        btnSms.setOnClickListener(v -> {
            String phone = edtPhone.getText().toString().trim();
            String message = edtMessage.getText().toString().trim();

            if (phone.isEmpty() || message.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập số điện thoại và nội dung!", Toast.LENGTH_SHORT).show();
                return;
            }

            // ACTION_SENDTO với Uri "smsto:"
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("smsto:" + phone));
            intent.putExtra("sms_body", message);
            startActivity(intent);
        });
    }
    }