package com.example.myapplication.Lab2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.os.Handler;

import com.example.myapplication.R;

public class BaiTap2Lab2Activity extends AppCompatActivity {

    private ProgressBar progressBar;
    private ScrollView contentLayout;
    private ImageView imgPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_tap2_lab2);

        // Ánh xạ view
        progressBar = findViewById(R.id.progressBar);
        contentLayout = findViewById(R.id.contentLayout);
        imgPhone = findViewById(R.id.imgPhone);

        // Hiển thị hiệu ứng tải
        new Handler().postDelayed(() -> {
            progressBar.setVisibility(View.GONE);
            contentLayout.setVisibility(View.VISIBLE);
        }, 2000);

        // Khi bấm vào icon điện thoại → mở ứng dụng gọi
        imgPhone.setOnClickListener(v -> {
            String phoneNumber = "(050)5551234";  // bạn có thể đổi số này tùy ý
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + phoneNumber));

            // chạy Intent gọi điện
            startActivity(intent);
        });
    }
}
