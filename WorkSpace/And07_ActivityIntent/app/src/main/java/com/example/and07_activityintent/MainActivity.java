package com.example.and07_activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    // 현재는 onCreate내부에서만 코드처리를 해도 무방함.
    // 추후에 여러 화면이나 Spring연동 시 새로고침 등의 처리가 필요할때는 수명주기가 있다는것을 생각하고, 적절한 수명주기를 이용하자.

    // 안드로이드도 Spring과 마찬가지로 Debugging을 잘하면 오류를 찾는게 빠르다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("수명주기", "onCreate:");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("수명주기", "onStart:");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("수명주기", "onResume:");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("수명주기", "onPause:");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("수명주기", "onStop:");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("수명주기", "onDestroy:");
    }
}