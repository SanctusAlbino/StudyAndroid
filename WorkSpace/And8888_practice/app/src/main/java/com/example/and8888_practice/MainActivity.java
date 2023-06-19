package com.example.and8888_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;

    Button btn_sum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        btn_sum = findViewById(R.id.btn_sum);

        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("아무거나1", "onClick: "+ Integer.parseInt(num1.getText().toString()));
                Log.d("아무거나2", "onClick: "+Integer.parseInt(num2.getText().toString()));
                Log.d("아무거", "onClick: "+);

            }
        });
     //   김건호();
       /* int money = 50;
        String abc = "abdaf";
        Result result = new Result();
        김건호(null);*/
    }

    // method(20);

    // 정의 ( int money )            호출  method( 20 ) ;     int money = 20 ;
    // 정의 ( Result result )            호출  method( ? ) ;    Result result = ? ;
    // 정의 (String abc )            호출  method( "dfdfd" ) ;   String abc = "dfdfd" ;
   /* public void method (int money){

    }

    public  void meth (String abc){

    }

    public void 김건호 (Result result){

    }*/






}