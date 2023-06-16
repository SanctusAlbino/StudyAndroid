package com.example.and07_activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
//
//        EditText str = findViewById(R.id.str);
//        EditText num = findViewById(R.id.num);
//        Button btn_str = findViewById(R.id.btn_str);
//        Button btn_num = findViewById(R.id.btn_num);
//        Button btn_sum = findViewById(R.id.sum);
//        Button jali = findViewById(R.id.jali);
//
//        btn_str.setOnClickListener(this);
//        btn_num.setOnClickListener(this);

        ArrayList<SumDTO> list = (ArrayList<SumDTO>) getIntent().getSerializableExtra("list");
        Log.d("여기5", "onCreate:"+list.size());
    }

    @Override
    public void onClick(View v) {
    }
}