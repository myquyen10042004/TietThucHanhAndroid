package com.example.myapplication.Lab2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import java.util.Random;

public class BaiTap1Lab2Activity extends AppCompatActivity {
    LinearLayout mainLayout;
    ImageView imgIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_tap1_lab2);

        mainLayout = findViewById(R.id.mainLayout);
        imgIcon = findViewById(R.id.imgIcon);

        // Mảng màu nền
        int[] colors = {
                0xFFE57373, // đỏ nhạt
                0xFF81C784, // xanh lá
                0xFF64B5F6, // xanh dương
                0xFFFFB74D, // cam
                0xFFBA68C8, // tím
                0xFFFF8A65  // cam đất
        };

        // Mảng icon (đặt ảnh trong res/drawable)
        int[] icons = {
                R.drawable.img_ga_con,
                R.drawable.img_canh_cut,

        };

        Random random = new Random();
        int colorIndex = random.nextInt(colors.length);
        int iconIndex = random.nextInt(icons.length);

        //  Đổi màu nền & icon
        mainLayout.setBackgroundColor(colors[colorIndex]);
        imgIcon.setImageResource(icons[iconIndex]);
    }
}