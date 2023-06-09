package com.example.and07_activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    EditText login_id, login_pw;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        EditText login_id = findViewById(R.id.login_id);
        EditText login_pw = findViewById(R.id.login_password);
        Button btn = findViewById(R.id.btn);

        //editText에 있는 글자를 가지고 오는 메소드 : editText.getText() 입니다. 이 메소드가 리턴해주는 타입은 뭘까?
        // id가 admin 비번이 admin1234일때 다음 화면으로 이동.
        // 그 외에는 Toast를 이용해서 아이디 또는 비밀번호 틀림이라고 메세지 띄우기

        btn.setOnClickListener(new View.OnClickListener(){ // 인터페이스를 new로 생성하면 메소드가 반드시 있어야 해서 익명의 클래스 지역을 만든다.
            @Override
            public void onClick(View v) {
                //Intent를 이용하면 화면 전환 => Intent객체 (안드로이드의 4대 컴포넌트의 통신을 담당) Act => 'Intent' =>Act
                // Context ? : 현재 화면에 떠있는 객체인지?
                // ex) DAO, VO => 화면에 떠있는 객체가 아니기 때문에 그래픽 작업을 하면 오류가 발생함. => 일반 클래스
                // ex) Act, Fragment => 화면에 떠있는 객체이기 때문에 그래픽 작업을 할수있음. 하지만 화면에 떠있는지의 상태를 알려줄수있는게 필요함 ==> Context
                // => 일반클래스에서도 그래픽처리가 가능하게 만드려면 Activity가 Context라는 것을 파라메터로 보내줬을때 가능함.

                Log.d("글자","onCreate:" + login_id.getText().toString());


                if (login_id.getText().toString().equals("admin")&&login_pw.getText().toString().equals("admin1234")) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("strkey", login_id.getText().toString()+"intent");
                    intent.putExtra("intkey", 10);
                    LoginDTO dto = new LoginDTO(login_id.getText().toString()+"1", login_pw.getText().toString()+"1");
                    intent.putExtra("dtokey", dto);

                    ArrayList<LoginDTO> list = new ArrayList<>(); //초기화식 , LoginDTO타입을 묶어놓을 공간마련
                    list.add(new LoginDTO("a1", "b1"));
                    list.add(new LoginDTO("a2", "b2"));
                    list.add(new LoginDTO("a3", "b3"));
                    list.add(new LoginDTO("a4", "b4"));
                    list.add(new LoginDTO("a5", "b5"));
                    intent.putExtra("list",list); //startActivity메소드 실행 전 데이터 담는 처리를 끝낸다.

                    startActivity(intent);
                    Toast.makeText(LoginActivity.this, "성공", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "실패", Toast.LENGTH_SHORT).show();
                }




            }
        });
    }

    public class kghVO implements Serializable{

    }

    public class kghClass implements Serializable {

    }
    public void method (Serializable k){
        //역직력화 : kghClass k2 = (kghClass) k ;
    }

}