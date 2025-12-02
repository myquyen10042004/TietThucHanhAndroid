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

public class M001RegisterFragment extends Fragment implements View.OnClickListener {
    private EditText edtEmail, edtPass, edtRepass;
    private Context mContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.m001_frg_register, container, false);
        initView(rootView);
        return rootView;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;

    }

    //ánh xạ view và gán sự kiện
    private void initView(View v) {
        edtEmail = v.findViewById(R.id.edt_email);
        edtPass = v.findViewById(R.id.edt_pass);
        edtRepass = v.findViewById(R.id.edt_re_pass);
        v.findViewById(R.id.tv_register).setOnClickListener(this);
        v.findViewById(R.id.iv_back).setOnClickListener(this);
    }

    //Xử lý khi bấm vào các nút quay lại và đăng ký
    @Override
    public void onClick(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_in));

        if (v.getId() == R.id.iv_back) {
            gotoLoginScreen();
        } else if (v.getId() == R.id.tv_register) {
            register(edtEmail.getText().toString(), edtPass.getText().toString(), edtRepass.getText().toString());
        }
    }

    //xử lý chuyển trang
    private void gotoLoginScreen() {
        ((MainActivityBuoi5) mContext).gotoLoginScreen();
    }
    //Xử lý đăng ký tài khoản, kiểm tra email, password
    private void register(String mail, String pass, String repass) {
        if (mail.isEmpty() || pass.isEmpty() || repass.isEmpty()) {
            Toast.makeText(mContext,"Empty value", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!pass.equals(repass)) {
            Toast.makeText(mContext,"Password is not match", Toast.LENGTH_SHORT).show();
        }
        SharedPreferences pref = mContext.getSharedPreferences(MainActivityBuoi5.SAVE_PREF,
                Context.MODE_PRIVATE);
        String savedPass = pref.getString(mail, null);
        if (savedPass != null) {
            Toast.makeText(mContext,"Email is existed!", Toast.LENGTH_SHORT).show();
            return;
        }
        pref.edit().putString(mail, pass).apply();
        Toast.makeText(mContext,"Register account successfully!", Toast.LENGTH_SHORT).show();
        gotoLoginScreen();
    }
}
