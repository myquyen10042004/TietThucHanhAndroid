package com.example.myapplication.Lab13_14.m000_frg_login;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainActivityBuoi5 extends AppCompatActivity {
    public static final String SAVE_PREF = "save_pref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_buoi5);
        gotoLoginScreen();
    }
    //Hàm chuyển sang màn hình REGISTER
    public void gotoRegisterScreen() {
        getSupportFragmentManager().beginTransaction().replace(R.id.ln_main, new
                M001RegisterFragment()).commit();
    }
    //Hàm chuyển sang màn hình LOGIN
    public void gotoLoginScreen() {
        getSupportFragmentManager().beginTransaction().replace(R.id.ln_main, new
                M000LoginFragment()).commit();
    }
}
