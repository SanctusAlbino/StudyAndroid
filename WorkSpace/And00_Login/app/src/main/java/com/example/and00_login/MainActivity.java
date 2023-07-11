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


        CommonConnection.KghCallBack callBack = new CommonConnection.KghCallBack() {
            @Override
            public void onResult(boolean isResult, String data) {
                Log.d("결과", "onResult: "+ data);
            }
        };
        Log.d("콜백", "콜백(인터페이스의 메모리):"+ callBack);


        btn_login.setOnClickListener(v->{
            CommonConnection conn = new CommonConnection(this, "login");
            conn.addParamMap("id",id.getText().toString());
            conn.addParamMap("pw",pw.getText().toString());
            conn.onExcute(callBack);

        });

    }// onExcute 메소드가 실행되면 일단 Spring으로 전송처리는 정상적으로 작동하낟. (결과를 가져오려면 어떻게 해야할까?)

    //올바른 방버아니여서 한번 확인하고 지울꺼
//    public static void test(String data){
//        Log.d("결과용", "onCreate: ");
//    }
    // 메소드 => 리턴타입이 있는 메소들를 구현, 호출을 자유롭게하고 사용하는 이유를 명확히 알고 있다.
    // 클래스 => 클래스 내부에 있는 멤버의 접근과 각각의 멤버를 구분하고 자유롭게 커스텀할수 있다.
    // 인터페이스 => 인터페이스의 규칙을 명확히 알고 자유롭게 구현하여 사용할 수 있다.

}