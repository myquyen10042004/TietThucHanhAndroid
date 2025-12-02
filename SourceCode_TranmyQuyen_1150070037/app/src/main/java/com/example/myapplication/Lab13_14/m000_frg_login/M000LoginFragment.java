package com.example.myapplication.Lab13_14.m000_frg_login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.Toast;


import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class M000LoginFragment extends Fragment implements View.OnClickListener {
    private EditText edtEmail, edtPass;
    private Context mContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.m000_frg_login, container, false);
        initView(rootView);
        return rootView;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    //Ánh xạ view và gán sự kiện click
    private void initView(View v) {
        edtEmail = v.findViewById(R.id.edt_email);
        edtPass = v.findViewById(R.id.edt_pass);
        v.findViewById(R.id.tv_login).setOnClickListener(this);
        v.findViewById(R.id.tv_register).setOnClickListener(this);
    }

    //Xử lý khi người dùng click
    @Override
    public void onClick(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_in));
    //nếu người dùng bấm đăng nhập sẽ kiểm tra email và mật khẩu
        if (v.getId() == R.id.tv_login) {
            login(edtEmail.getText().toString(), edtPass.getText().toString());
    //còn nếu người dùng bấm đăng ký sẽ đi đến trang đăng ký
        } else if (v.getId() == R.id.tv_register) {
            gotoRegisterScreen();
        }
    }
   // chuyển trang
    private void gotoRegisterScreen() {
        ((MainActivityBuoi5) mContext).gotoRegisterScreen();
    }

    //xử lý chức năng đăng nhập
    private void login(String mail, String pass) {
        if (mail.isEmpty() || pass.isEmpty()) {
            Toast.makeText(mContext,"Empty value", Toast.LENGTH_SHORT).show();
            return;
        }

        //lưu thông tin đăng nhập và SharedPreferences
        SharedPreferences pref = mContext.getSharedPreferences(MainActivityBuoi5.SAVE_PREF,
                Context.MODE_PRIVATE);
        String savedPass = pref.getString(mail, null);
        if (savedPass == null) {
            Toast.makeText(mContext,"Email is not existed!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!pass.equals(savedPass)) {
            Toast.makeText(mContext,"Password is not correct!", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(mContext,"Login accountsuccessfully!", Toast.LENGTH_SHORT).show();
    }
}