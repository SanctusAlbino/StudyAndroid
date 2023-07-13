package com.example.project02_lastproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.project02_lastproject.R;
import com.example.project02_lastproject.common.CommonConn;
import com.example.project02_lastproject.customer.CustomerFragment;
import com.example.project02_lastproject.databinding.ActivityMainBinding;
import com.example.project02_lastproject.employees.EmpFragment;

import me.ibrahimsn.lib.OnItemReselectedListener;
import me.ibrahimsn.lib.OnItemSelectedListener;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //getSupportFragmentManager().beginTransaction().replace(R.id.container, new CustomerFragment()).commit();

        binding.bottomBar.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {
                if(i==0){
                    //Customer패키지 내부에 CustomerFragment를 만들고 i가 0일때 해당하는 Fragment가 Container에 붙게 처리하기
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new CustomerFragment()).commit();
                } else if (i==1) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new EmpFragment()).commit();
                } else if (i==2) {

                } else if (i==3) {

                }
                return true;
            }
        });

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