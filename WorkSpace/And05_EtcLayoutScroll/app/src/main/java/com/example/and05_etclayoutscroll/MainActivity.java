package com.example.and05_etclayoutscroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HorizontalScrollView hzs = findViewById(R.id.hzs);
        TextView tv_text = findViewById(R.id.tv_text); //내가 레이아웃에 만든 위젯을 찾아서 java코드 변수로 초기화
        //TextView.ksjdflk <== Static Member :클래스가 인스턴스화 하지 않아도 메모리에 이미 올라가 있는 자원
        //tv_text.append(); <==Instence Member : 클래스가 인스턴스화 해야지만 메모리에 로딩되는 멤버
        tv_text.append("안녕하세요.\n");

        for (int i = 0; i < 50; i++) {

            tv_text.append(i+"안녕하세요\n");
            for (int j = 0; j < 17; j++) {
                tv_text.append(j+"안녕하세요");
            }
        }
        Button btn = findViewById(R.id.btn);
        ScrollView sv = findViewById(R.id.sv);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("스크롤 위치", "getScroll"+sv.getScrollY());
                sv.scrollTo(0,sv.getScrollY()+100);
                hzs.smoothScrollTo(hzs.getScrollX()+100, 0);
            }
        });

       // static키워드가 있어서 최기화 과정 없이 사용가능. kgh.ATTR
       // static키워드가 없어서 초기화를 시켜야만 사용가능 new kgh().append("초기화해야지 사용가능);

    }
}