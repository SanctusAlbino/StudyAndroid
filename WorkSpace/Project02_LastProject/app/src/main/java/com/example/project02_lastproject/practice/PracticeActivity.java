package com.example.project02_lastproject.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.project02_lastproject.R;
import com.example.project02_lastproject.common.RetrofitClient;
import com.example.project02_lastproject.common.RetrofitInterface;
import com.example.project02_lastproject.databinding.ActivityPracticeBinding;

import java.util.HashMap;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PracticeActivity extends AppCompatActivity {
    ActivityPracticeBinding binding;
    //Callbackabn callback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPracticeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        callback = new Callbackabn() {
//            @Override
//            public void onResult(String data) {
//                binding.tvResult.setText("응답:"+data);
//            }
//        };

        binding.btnSelect.setOnClickListener(v->{
            //RetrofitClient: 접속 방법, 컨버터 등 통신에 대한 전반적인 방법이 있는 객체
            //RetrofitInterface : 접속 후 데이터 전송 방식, 파라메터 탕비 등등의 기능에 가까운 객체

            commonExcute(binding.edtUrl.getText().toString(),new HashMap<>(), new Callbackabn(){

                @Override
                public void onResult(String data) {
                    binding.tvResult.setText("Selelct결과 1은 성공"+data);
                }
            });
//            api.clientPostMethod(binding.edtUrl.getText().toString(), new HashMap<>()).enqueue(new Callback<String>() {
//                @Override
//                public void onResponse(Call<String> call, Response<String> response) {
//                    callback.onResult(response.body());
//                }
//
//                @Override
//                public void onFailure(Call<String> call, Throwable t) {
//                    callback.onResult(t.getMessage());
//                }
//            });
        });


        binding.btnInsert.setOnClickListener(v->{
            HashMap<String, Object> params = new HashMap<>();
            params.put("col1", "random값1"+ new Random().nextInt(100));
            params.put("col2", "random값2"+ new Random().nextInt(100));

            commonExcute("insert.crud", params, data -> {
                binding.tvResult.setText("Insert결과 1은 성공"+data);
            });
//            api.clientPostMethod("insert.crud", params).enqueue(new Callback<String>() {
//                @Override
//                public void onResponse(Call<String> call, Response<String> response) {
//                    binding.tvResult.setText(response.body());
//                }
//
//                @Override
//                public void onFailure(Call<String> call, Throwable t) {
//                    binding.tvResult.setText(t.getMessage());
//                }
//            });
        });

        binding.btnUpdate.setOnClickListener(v->{
//            method(new Callbackabn() {
//                @Override
//                public void onResult(String data) {
//
//                    Log.d("로그", "onResult: 여기가 실행됨 ");
//                }
//            });
            //method(new AbnVO());
        });
    }


    //2번
    public void commonExcute(String url, HashMap<String, Object> map, Callbackabn callback){
        RetrofitInterface api = new RetrofitClient().getRetrofit().create(RetrofitInterface.class);
        api.clientPostMethod(url, map).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.onResult(t.getMessage());
            }
        });
    }

//    public void method(AbnVO vo){
//        vo.method();
//    }
//
//    public class AbnVO{
//        public void method(){
//            Log.d("로그", "onResult: 여기가 실행됨 ");
//        }
//    }

    public void method(Callbackabn callback){
        callback.onResult("data");
        Toast.makeText(this, "메소드가 호출되었습니다.",Toast.LENGTH_SHORT).show();
    }


    //1번 인터페이스
    public interface Callbackabn{
        public void onResult(String data);
    }


}