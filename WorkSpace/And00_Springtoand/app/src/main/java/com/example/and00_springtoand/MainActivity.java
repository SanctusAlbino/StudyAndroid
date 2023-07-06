package com.example.and00_springtoand;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ApiInterface가 초기화 되어야함
        //초기화 식 : ApiInterface name = Retrofit.create(ApiInterface.class);
//        // Collection 자료구조.
//        HashMap<String , Object> map = new HashMap<>();     //->DTO없이도 사용가능
//        map.put("Spring변수이름", "보내주고싶은값");


        RetrofitInterface api = new RetrofitClient().getRetrofit().create(RetrofitInterface.class);
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("param", "값안드3");
        paramMap.put("param", "값안dd드2");
        paramMap.put("param", "값안dd드4");
        //CallBack : 희미하게 KakaoLogin
        //jsp 카카오 로그인 버튼 누름 -> Controller -> Rest API (카카오 서버에 특정 맵핑을 호출하고, 파라메터를 넘겨줌(Client_id))
        // ->페이지implementation group: 'com.google.code.gson', name: 'gson', version: '2.8.9'
        //
        //    // https://mvnrepository.com/artifact/com.squareup.retrofit2/retrofit
        //    //실제 URL을 요청하는 객체(API)
        //    implementation group: 'com.squareup.retrofit2', name: 'retrofit', version: '2.9.0'
        //
        //    // https://mvnrepository.com/artifact/com.squareup.retrofit2/converter-scalars
        //    //String json 단일 데이터 타입용 컨버터
        //    implementation group: 'com.squareup.retrofit2', name: 'converter-scalars', version: '2.9.0'
        //-> 사용자가 카카오 로그인을 함.(언제끝날지 모름) 끝나면 내가 만들어둔 나의 Controller로 데이터를 주라 이게 Callback!

        //Dialog처리 : 사용자는 기다리는 일을  잘 못함. (=> 아무런 디자인 처리 없이)
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("레트로핏");
        dialog.setMessage("데이터를 가져오는중 .....");
        dialog.setProgress(ProgressDialog.STYLE_SPINNER);
        dialog.setCancelable(false);
        dialog.show();

        api.clientPostMethod("list.cu", paramMap).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("레트로핏", "onResponse: 응답이 왔음. Spring에서 이후 처리 진행" + response.body());
                dialog.dismiss();
                // 어댑터 생성, 리사이클러뷰 연결...
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("실패", "onFailure: url, 포트, Spring응답없음 등으로 실패");
            }
        });
    }
}