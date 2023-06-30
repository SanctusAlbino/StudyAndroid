package com.example.project01_kghtalk.exam;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

public class KghAdapterParent {

    public abstract static class KghAdapter<KVH extends KghViewHolder>{
        public abstract KVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType);
        public abstract void onBindViewHolder();
        public abstract int getItemCount();
    }





    public abstract static class KghViewHolder{
        //디자인 파일을 묶어놓은 객체가 필요 ==> View
        @NonNull
        final View view; // 상수의 규칙ㄱ (1. 상수를 선언과 동시에 값할당 ==> 초기화해놓는 방법)
                        //                 2. 생성자를 이용해서 초기화 하는 방법

        public KghViewHolder(@NonNull View view) {
            this.view = view; // 이때는 값할당 한번할수있음
        }
    }
}
