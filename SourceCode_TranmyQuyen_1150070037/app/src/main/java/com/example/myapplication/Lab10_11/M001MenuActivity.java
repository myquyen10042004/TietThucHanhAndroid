package com.example.myapplication.Lab10_11;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class M001MenuActivity extends AppCompatActivity {

    ImageView imgBachDuong, imgKimNguu, imgSongTu, imgCuGiai, imgSuTu,
            imgXuNu, imgThienBinh, imgBoCap, imgNhanMa, imgMaKet,
            imgBaoBinh, imgSongNgu;

    TextView tvName, tvContent;
    Button btnXemChiTiet;


    int indexDangChon = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_m001_menu);

        anhXaView();
        xuLySuKienClick();
        xuLyXemChiTiet();
    }

    private void anhXaView() {

        imgBachDuong = findViewById(R.id.imgBachDuong);
        imgKimNguu = findViewById(R.id.imgKimNguu);
        imgSongTu = findViewById(R.id.imgSongTu);
        imgCuGiai = findViewById(R.id.imgCuGiai);
        imgSuTu = findViewById(R.id.imgSuTu);
        imgXuNu = findViewById(R.id.imgXuNu);
        imgThienBinh = findViewById(R.id.imgThienBinh);
        imgBoCap = findViewById(R.id.imgBoCap);
        imgNhanMa = findViewById(R.id.imgNhanMa);
        imgMaKet = findViewById(R.id.imgMaKet);
        imgBaoBinh = findViewById(R.id.imgBaoBinh);
        imgSongNgu = findViewById(R.id.imgSongNgu);

        tvName = findViewById(R.id.tvName);
        tvContent = findViewById(R.id.tvContent);
        btnXemChiTiet = findViewById(R.id.btnXemChiTiet);
    }

    private String[] tenCung = {
            "Bạch Dương", "Kim Ngưu", "Song Tử", "Cự Giải",
            "Sư Tử", "Xử Nữ", "Thiên Bình", "Bọ Cạp",
            "Nhân Mã", "Ma Kết", "Bảo Bình", "Song Ngư"
    };

    private String[] moTaCung = {
            "Bạch Dương là người năng động, quyết đoán...",
            "Kim Ngưu là người mạnh mẽ, kiên trì...",
            "Song Tử thông minh, hoạt bát, giao tiếp tốt...",
            "Cự Giải sống tình cảm, biết quan tâm...",
            "Sư Tử tự tin, mạnh mẽ và thích lãnh đạo...",
            "Xử Nữ tỉ mỉ, chăm chỉ và kỹ tính...",
            "Thiên Bình thích hòa bình, công bằng...",
            "Bọ Cạp bí ẩn, mạnh mẽ, nội tâm sâu sắc...",
            "Nhân Mã tự do, thích khám phá...",
            "Ma Kết kỷ luật, nghiêm túc, có trách nhiệm...",
            "Bảo Bình sáng tạo, độc lập...",
            "Song Ngư nhạy cảm, lãng mạn..."
    };

    private int[] hinhCung = {
            R.drawable.bachduong,
            R.drawable.kim_nguu,
            R.drawable.gemini,
            R.drawable.cu_giai,
            R.drawable.su_tu,
            R.drawable.xu_nu,
            R.drawable.thien_binh,
            R.drawable.bo_cap,
            R.drawable.nhan_ma,
            R.drawable.ma_ket,
            R.drawable.bao_binh,
            R.drawable.song_ngu
    };

    private void hienThiCung(int index) {
        indexDangChon = index;
        tvName.setText(tenCung[index]);
        tvContent.setText(moTaCung[index]);
    }


    private void xuLySuKienClick() {

        imgBachDuong.setOnClickListener(v -> hienThiCung(0));
        imgKimNguu.setOnClickListener(v -> hienThiCung(1));
        imgSongTu.setOnClickListener(v -> hienThiCung(2));
        imgCuGiai.setOnClickListener(v -> hienThiCung(3));
        imgSuTu.setOnClickListener(v -> hienThiCung(4));
        imgXuNu.setOnClickListener(v -> hienThiCung(5));
        imgThienBinh.setOnClickListener(v -> hienThiCung(6));
        imgBoCap.setOnClickListener(v -> hienThiCung(7));
        imgNhanMa.setOnClickListener(v -> hienThiCung(8));
        imgMaKet.setOnClickListener(v -> hienThiCung(9));
        imgBaoBinh.setOnClickListener(v -> hienThiCung(10));
        imgSongNgu.setOnClickListener(v -> hienThiCung(11));
    }


    private void xuLyXemChiTiet() {
        btnXemChiTiet.setOnClickListener(v -> {

            if (indexDangChon == -1) {
                Toast.makeText(this, "Vui lòng chọn cung!", Toast.LENGTH_SHORT).show();
                return;
            }

            guiDuLieu(indexDangChon);
        });
    }


    private void guiDuLieu(int index){
        Intent intent = new Intent(M001MenuActivity.this, M002DetailActivity.class);
        intent.putExtra("tenCung", tenCung[index]);
        intent.putExtra("moTa", moTaCung[index]);
        intent.putExtra("hinh", hinhCung[index]);
        startActivity(intent);
    }

}
