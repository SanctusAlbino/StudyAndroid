package com.example.and03_linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setContentView(R.layout.lineartest);
//        setContentView(R.layout.linear4);
//        LinearLayout line1 = findViewById(R.id.line1);
//        line1.setGravity(1);
//
//
//
//        Log.i("김건호", "o로그 info");
//        Log.w("김건호", "경고 ",null );
//        if(line1 != null){
//            Log.d("김건호", "Linear가 null이 아님 ");
//
//        }else{
//            //Log.d("김건호", "Linear가 null임 ");
//            Log.e("김건호", "오류로 로그 찍기 ", null);
//        }
    }
}