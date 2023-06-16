package com.example.and07_activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // 현재는 onCreate내부에서만 코드처리를 해도 무방함.
    // 추후에 여러 화면이나 Spring연동 시 새로고침 등의 처리가 필요할때는 수명주기가 있다는것을 생각하고, 적절한 수명주기를 이용하자.

    // 안드로이드도 Spring과 마찬가지로 Debugging을 잘하면 오류를 찾는게 빠르다.
    Button  phone_btn, search_btn, send_btn, btn_str, btn_num, jali, sum;
    EditText phone, send, search, str, num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        str = findViewById(R.id.str);
        num = findViewById(R.id.num);
        btn_str = findViewById(R.id.btn_str);
        btn_num = findViewById(R.id.btn_num);
        sum = findViewById(R.id.sum);
        jali = findViewById(R.id.jali);

        btn_str.setOnClickListener(this);
        btn_num.setOnClickListener(this);


        Log.d("수명주기", "onCreate:");
        Intent intent= getIntent(); //방금 LoginActivity에서 startActivity( ' intent ' )사용된 intent를 가져옴. (내부에 넣어둔 putExtra)데이터를 빼오기 위해서)

        String strValue = intent.getStringExtra("strkey");
        int intValue = intent.getIntExtra("intkey", -1);
        LoginDTO dto = (LoginDTO) intent.getSerializableExtra("dtokey");//객체의 타입을 주고 강제로 바꾸는것 ==> 역직렬화 ==> 내부에 있는 멤버를 사용하기 위해 Serializable=>dto
        // name으로 값을 찾았을때 없다면, 기본값을 어떤걸로 할껀지 defaultvalue
        Log.d("수명주기", "onCreate:"+strValue);
        Log.d("수명주기", "onCreate:"+intValue);
        Log.d("수명주기", "onCreate:"+dto.getId());

        ArrayList<LoginDTO> list = (ArrayList<LoginDTO>) intent.getSerializableExtra("list");
        Log.d("수명주기", "onCreate:"+ list.size());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("수명주기", "onStart:");

         phone =findViewById(R.id.phone);
         search =findViewById(R.id.search);
         send = findViewById(R.id.send);
         phone_btn = findViewById(R.id.phone_btn);
         search_btn = findViewById(R.id.search_btn);
         send_btn = findViewById(R.id.send_btn);

        //lamda 인터페이스를 파라메터로 넘겨야할때 함수로 메소드 지역만 만들어냄. this를 써보면 new와 함수형 lamda식을 알수있음
        // 주의사항. 람다식에서 인터페이스 함수형으로 쓸대 인터페이스 내부에는 메소드가 반드시 하나여야만함
        // 명시적 : activity => activity.class 이동시 많이 사용.
        // 암시적, 묵시적: activity => action(내가 없는 기능) 사용할때
        phone_btn.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:/"+phone.getText().toString())
                    );
            startActivity(intent);
        });

        search_btn.setOnClickListener(this);
        send_btn.setOnClickListener(this);

        sum.setOnClickListener(this);
        jali.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.search_btn){
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, search.getText().toString());
            startActivity(intent);

        } else if (v.getId()==R.id.send_btn) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("smsto:"+Uri.encode("010-1234-5678")));
            intent.putExtra("sms_body", send.getText().toString());
            startActivity(intent);
            //암시적 인텐트나 명시적 인텐트
        } else if (v.getId()==R.id.btn_str) {
            Intent intent = new Intent(this, TestActivity.class);
            Log.d("이거","onClick:" +str.getText().toString());
            intent.putExtra("who", str.getText().toString());
            startActivity(intent);
        } else if (v.getId()==R.id.btn_num) {
            Intent intent = new Intent(this, TestActivity.class);
            Log.d("이거1","onClick:"+Integer.parseInt(num.getText().toString()));
            intent.putExtra("whod", num.getText().toString());
            startActivity(intent);
        } else if (v.getId()==R.id.sum) {
            Intent intent = new Intent(this, TestActivity.class);
            Log.d("이거2", "onClick:"+str.getText().toString()+ Integer.parseInt(num.getText().toString()));
            SumDTO dto = new SumDTO(str.getText().toString(), Integer.parseInt(num.getText().toString()));
            intent.putExtra("sum",dto);
            startActivity(intent);
        } else if (v.getId()==R.id.jali) {
            Intent intent = new Intent(this, TestActivity.class);
            ArrayList<SumDTO> list = new ArrayList<>();
            list.add(new SumDTO(str.getText().toString(), Integer.parseInt(num.getText().toString())));
            list.add(new SumDTO(str.getText().toString(), Integer.parseInt(num.getText().toString())));
            list.add(new SumDTO(str.getText().toString(), Integer.parseInt(num.getText().toString())));
            list.add(new SumDTO(str.getText().toString(), Integer.parseInt(num.getText().toString())));
            list.add(new SumDTO(str.getText().toString(), Integer.parseInt(num.getText().toString())));
            intent.putExtra("list",list);
           // Log.d("이거3","onClick:"+list.size());
            startActivity(intent);
        }

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