package com.example.project02_lastproject.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.project02_lastproject.MainActivity;
import com.example.project02_lastproject.R;
import com.example.project02_lastproject.common.CommonConn;
import com.example.project02_lastproject.common.CommonVar;
import com.example.project02_lastproject.databinding.ActivityLoginBinding;
import com.google.gson.Gson;
import com.google.gson.ToNumberStrategy;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(v -> {
            if(binding.edtId.getText().toString().length()<1
                || binding.edtPw.getText().toString().length()<1){
                Toast.makeText(this, "아이디또는 비번입력", Toast.LENGTH_SHORT).show();
                return;
            }
            CommonConn conn = new CommonConn(this, "amlogin");
            conn.addParamMap("id", binding.edtId.getText().toString());
            conn.addParamMap("password", binding.edtPw.getText().toString());
            conn.onExcute((isResult, data) -> {
              if(isResult){
                  CommonVar.loginInfo = new Gson().fromJson(data, AndMemberVO.class);
                  if(CommonVar.loginInfo==null){
                      Toast.makeText(this, "아이디 비번 확인", Toast.LENGTH_SHORT).show();
                  }else{
                      //CommonVar.loginInfo = vo;
                      Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                      startActivity(intent);
                  }
              }
            });


        });
    }
}