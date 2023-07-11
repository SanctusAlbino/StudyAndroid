package com.example.project02_lastproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.project02_lastproject.R;
import com.example.project02_lastproject.common.CommonConn;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CommonConn conn = new CommonConn(this, "member/login");
        conn.addParamMap("id","admin");
        conn.addParamMap("pw","admin1234");
        conn.onExcute((isResult, data) -> {
            Log.d("결과값", "onCreate: " + data+"isResult"+isResult);
        });

//        CommonConn.AbCallBack callBack = new CommonConn.AbCallBack() {
//            @Override
//            public void onResult(boolean isResult, String data) {
//                Log.d("결과", "onResult: "+ data);
//            }
//        };
    }
}