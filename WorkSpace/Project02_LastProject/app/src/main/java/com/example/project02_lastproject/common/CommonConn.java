package com.example.project02_lastproject.common;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommonConn {
    private final String TAG = "CommonConn";
    private HashMap<String, Object> paramMap;
    private Context context; //화면위에 토스트, ProgressDialog를 보여주기위한 용도
    private String mapping; //list.cu, login 등의 맵핑을 받아오기위한것.
    private ProgressDialog dialog;
    private AbCallBack callBack;

    public CommonConn(Context context, String mapping) {
        this.context = context;
        this.mapping = mapping;
        this.paramMap = new HashMap<>();
    }

    public void addParamMap(String key, Object value){
        if(key == null) {
            Log.e(TAG, "파라메터 key값이 null이 들어와서 추가 안했음.");
        } else if (value == null) {
            Log.e(TAG, "파라메터 value값이 null이 들어와서 추가 안했음 경우에 따라 커스텀해야함.");
        }else{
            paramMap.put(key,value);
        }
    }

    private void onPreExcute(){
        if (context != null && dialog == null){
            dialog = new ProgressDialog(context);
            dialog.setProgress(ProgressDialog.STYLE_SPINNER);
            dialog.setTitle("Common");
            dialog.setMessage("로딩중입니다");
            dialog.setCancelable(false);
            dialog.show();
        }
    }

    public void onExcute(AbCallBack callBack){
        onPreExcute();
        this.callBack = callBack;
        RetrofitInterface api = new RetrofitClient().getRetrofit().create(RetrofitInterface.class);
        api.clientPostMethod(mapping, paramMap).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d(TAG, "onResponse: " +response.body());
                onPostExcute(true, response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d(TAG, "onFailure: 서버와의 연결 실패" +t.getMessage());
                Toast.makeText(context, "서버와의 연결에 실패", Toast.LENGTH_SHORT).show();

                onPostExcute(false,null);
            }
        });
    }
    private void onPostExcute(boolean isResult , String data) {
        if (dialog != null) {
            dialog.dismiss();
        }
        callBack.onResult(isResult, data);
    }


    public interface AbCallBack{
        public void onResult(boolean isResult, String data);
    }
}
