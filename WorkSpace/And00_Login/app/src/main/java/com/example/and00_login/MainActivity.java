package com.example.and00_login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

        EditText id, pw;
        Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id= findViewById(R.id.id);
        pw = findViewById(R.id.pw);
        btn_login = findViewById(R.id.btn_login);





        btn_login.setOnClickListener(v->{
            CommonConnection conn = new CommonConnection(this, "login");
            conn.addParamMap("id",id.getText().toString());
            conn.addParamMap("pw",pw.getText().toString());
            conn.onExcute(new CommonConnection.KghCallBack() {
                @Override
                public void onResult(boolean isResult, String data) {

                }
            });
            Log.d("결과", "onCreate: ");
        });
    }// onExcute 메소드가 실행되면 일단 Spring으로 전송처리는 정상적으로 작동하낟. (결과를 가져오려면 어떻게 해야할까?)

    //올바른 방버아니여서 한번 확인하고 지울꺼
//    public static void test(String data){
//        Log.d("결과용", "onCreate: ");
//    }

}