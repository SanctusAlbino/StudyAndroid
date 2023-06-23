package com.example.and09_fragmentadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.and09_fragmentadapter.Practice.MelonFragment;
import com.example.and09_fragmentadapter.grid.GridFragment;
import com.example.and09_fragmentadapter.listv.ListFragment;
import com.example.and09_fragmentadapter.recyler.NormalClass;
import com.example.and09_fragmentadapter.recyler.RecyclerFragment;

public class AdapterActivity extends AppCompatActivity {
    //ListView listv;
    FrameLayout container_fl2;
    Button btn_list, btn_grid, btn_recy, btn_practice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        //용도나 형태에 따라서 어댑터의 종류는 많음. 사용빈도가 가장 낮은거는 오래 된 방식.(Array형태로 String 넣는 방식)
        //ArrayAdapter (기본적으로 안드로이드에서 제공해주는 어댑터)

        //Context(맥락): 현재 모든 앱의 상태, 그리고 화면에 떠있는 객체의 상태등 모든 상태를 알수있는 변수.
        // 액티비티냐 화면에 떠있는 객체(상태)이냐를 묻는것이라고 판단을 하면 더 편함.

        //ArrayAdapter( Context, 반복되는 모양의 xml, 내용이 바뀌어야한다면 사용될데이터);
        //기본 템플릿 : android.R.layout.simple_list_item_1
        //기본 템플릿으로는 모든 모양을 만들수가 없음. Custom=> 이후 사용하게 됨(Adapter)
//        String[] arrItem = new String[10];
//        for (int i = 0; i <10 ; i++) {
//            arrItem[i] = "KGH" + UUID.randomUUID().toString();
//        }
//
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrItem);
        btn_list = findViewById(R.id.btn_list);

        FragmentManager manager = getSupportFragmentManager();

        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                manager.beginTransaction().replace(R.id.container_fl2,new ListFragment()).commit();
            }
        });

        btn_grid = findViewById(R.id.btn_grid);

        btn_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                manager.beginTransaction().replace(R.id.container_fl2, new GridFragment()).commit();
            }
        });

        btn_practice= findViewById(R.id.btn_practice);

        btn_practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                manager.beginTransaction().replace(R.id.container_fl2, new MelonFragment()).commit();
            }
        });

        btn_recy = findViewById(R.id.btn_recy);

        btn_recy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.beginTransaction().replace(R.id.container_fl2, new RecyclerFragment()).commit();
            }
        });

        new NormalClass().testToast(this, "쓰고 싶은거 나는 액티비티");
//        listv = findViewById(R.id.listv);
//
//        listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.d("리스트뷰", "onItemClick: "+ position);
//                // position을 활용해서 KGH UUID가 Toast메세지로 나오게 처리해보기.
//                Toast.makeText(AdapterActivity.this, arrItem[position], Toast.LENGTH_SHORT).show();
//
//                //TextView tv = (TextView) view;
//
//            }
//
//        });
//
//
//
//        listv.setAdapter(adapter);
    }
}