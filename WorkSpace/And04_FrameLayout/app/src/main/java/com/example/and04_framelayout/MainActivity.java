package com.example.and04_framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_change, btn_change0;
    //ImageView img1, img2, img3;

    ArrayList<ImageView> imgList = new ArrayList<>();

    int frag =0;
    //현재 객체를 선언만 해둔 상태에서 4개의 객체 모두 null인 상태이다.
    //null이 아니게 하려면 어떤 처리가 필요할까?

    //null이 아니게 만들고 if문을 이용하여 nullCheck를 하고 log를 찍어보기
    //nullCheck : btn... img 3개중 하나라도 null이라면 null이 섞여있음이라는 로그가 찍힘. 그게 아니라면 전부 초기화 완료 라고 로그에 찍힘

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_change = findViewById(R.id.btn_change);
        btn_change0 = findViewById(R.id.btn_change0);

        imgList.add(findViewById(R.id.imgv1));
        imgList.add(findViewById(R.id.imgv2));
        imgList.add(findViewById(R.id.imgv3));

//        img1 = findViewById(R.id.imgv1);
//        img2 = findViewById(R.id.imgv2);
//        img3 = findViewById(R.id.imgv3);

        //버튼의 클릭을 감지하는 메소드 . 인터페이스 View.OnClickListner<-
        //1. 직접 인터페이스를 인스턴스화하여 파라메터로 넘기는 방법
//        View.OnClickListener kghOnclick = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("버튼", " 버튼이 눌림 ");
//            }
//        };
        // int num = 10 ;  sum(num); == sum(10)
        //2. 인터페이스를 초기화 할수있는 new 생성자로 파라메터를 넘기는 방법
//        btn_change.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("버튼", " 버튼이 눌림 new ");
//            }
//        });

        //3.방법을 이용해서 onClick메소드를 직접 구현함. 버튼을 누를때마다 밑의 메소드가 실행되게 하려면 어떻게 해야할까?  ↓
//        btn_change0.setOnClickListener(new KghEvent());//??
//
//        onClick(btn_change0);

        //4. 자바의 인터페이스 단점을 보완 => lamda (람다식, 함수형으로 new나 불필요한 코드를 생략하고 사용하는 법)
        // 인터페이스의 abstract메소드가 1개의 경우만 사용가능. (인터페이스의 내부 구조를 모르면 사용불가)
//        btn_change.setOnClickListener(v->{//인터페이스가 주는 파라메터를 (v)써주고 메소드지역을 ->가르킴{}
//
//        });
        btn_change0.setOnClickListener(this); //내부적으로 가지고 있는 interface가 setter에 의해서 초기화됨.
        btn_change.setOnClickListener(this);
        btn_change0.setOnClickListener(v->{ //내부적으로 가지고있는 interface가 setter에 의해서 초기화됨.
            frag -- ;
            if(frag == -1){
                frag = 2;
            }
            Log.d("로그", "변수 Flag: " + frag);
            changeImage();
        });



        btn_change.setOnClickListener(v->{ //내부적으로 가지고있는 interface가 setter에 의해서 초기화됨.
            frag ++ ;
            if(frag == imgList.size()){
                frag = 0;
            }
            Log.d("로그", "변수 Flag: " + frag);
            changeImage();
        });

    }

    // 3. 인터페이스를 상속받는 방법
    // -> Spring MVC의 경우에는 DAO또는 Service가 반드시 구현해야만 하는 메소드의 형태를 만들어서 설계도 개념으로 사용.( 많은 개발자가 협업시 편리한방법)
    // -> Android <- 다형성을 이용한 방법. : View.OnClickLister <= onClick이라는 메소드를 반드시 가지고 있음.
    //                                      View.OnClickLister라는것을 상속받은 Class는 ==ViewOnClickLister와 같다가 성립.

    //java코드를 이용하여 이미지 바꾸기 클릭시 계속해서 이미지가 바뀌게 처리해보기.
    //setVisibility속성을 잘 이용할것
    // hint : 반복은 사용자가 버튼을 클릭하는 행위. 반복문 x
    //          몇번째 누르고 있는지를 코드나 변수로 인지를 해야함.

    public void changeImage(){
        for (int i = 0; i < imgList.size(); i++) {
            imgList.get(i).setVisibility(View.GONE);
        }
        imgList.get(frag).setVisibility(View.VISIBLE);
    }

//    int flag =1;
    @Override
    public void onClick(View v) {
        Log.d("버튼", " 인터페이스 상속받아서 버튼 눌림을 감지 " + frag);
        frag++;
//
//        if(v.getId() == R.id.btn_change){
//            if ( img3.getVisibility() == View.VISIBLE){
//                img3.setVisibility(View.GONE);
//            } else if (img2.getVisibility()==View.VISIBLE) {
//                img2.setVisibility(View.GONE);
//            } else if(img1.getVisibility()==View.VISIBLE){
//                img2.setVisibility(View.VISIBLE);
//                img3.setVisibility(View.VISIBLE);
//            }
//        } else if (v.getId() == R.id.btn_change0) {
//            if ( img3.getVisibility() == View.VISIBLE){
//                img3.setVisibility(View.GONE);
//                img2.setVisibility(View.GONE);
//            } else if (img1.getVisibility()==View.VISIBLE) {
//
//                img2.setVisibility(View.VISIBLE);
//            } else if (img2.getVisibility()==View.VISIBLE){
//                img1.setVisibility(View.VISIBLE);
//                img3.setVisibility(View.VISIBLE);
//
//            }
        }


    }

