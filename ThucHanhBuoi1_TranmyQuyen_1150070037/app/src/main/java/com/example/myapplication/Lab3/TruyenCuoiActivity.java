package com.example.myapplication.Lab3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class TruyenCuoiActivity extends AppCompatActivity {

    private String topicName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_truyen_cuoi);

        showFrg(new M000SplashFrg());
    }

    void showFrg(Fragment frg) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.ln_main, frg, null)
                .commit();
    }

    public void gotoM001Screen() {
        showFrg(new M001ScreenChuDe());
    }

    public void gotoM002Screen(String topicName) {
        this.topicName = topicName;

        Bundle bundle = new Bundle();
        bundle.putString("TOPIC_NAME", topicName);

        M002ScreenDanhSachTruyen frg = new M002ScreenDanhSachTruyen();
        frg.setArguments(bundle);

        showFrg(frg);
    }

    public void gotoM003Screen(Bundle bundle) {
        M003ScreenDocTruyen frg = new M003ScreenDocTruyen();
        frg.setArguments(bundle);
        showFrg(frg);
    }

    public void backToM001Screen() {
        gotoM001Screen();
    }

    public void backToM002Screen() {
        if (topicName != null) {
            gotoM002Screen(topicName);
        } else {
            gotoM001Screen();
        }
    }
}
