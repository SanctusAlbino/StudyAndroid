package com.example.and09_fragmentadapter.recyler;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and09_fragmentadapter.R;
import com.example.and09_fragmentadapter.listv.ListDTO;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class RecyclerFragment extends Fragment {

    RecyclerView recv;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler, container, false);
        //Context : 현재 앱의 모든 상태와 외부의 리소스 등에 접근하는 모든 기능들을 의미함.
        // 안드로이드 4대 컴포넌트는 모두 Context를 이용해서 만들어졌고 4대 컴포넌트들만 Context에 자유롭게 접근이 가능하다.
        // 4대컴포넌트 <= Activity
        new NormalClass().testToast(getContext(), "플래그먼트이기 때문에 get으로 받아옴");

        recv = v.findViewById(R.id.recv);
        ArrayList<RecvDTO> Relist = new ArrayList<>();

        Relist.add(new RecvDTO(R.drawable.img1,"이름", "ㅇㄴ", "ㄴㅇ", "ㄴㅇㄹ"));
        Relist.add(new RecvDTO(R.drawable.img2,"이름", "ㅇㄴ", "ㄴㅇ", "ㄴㅇㄹ"));
        Relist.add(new RecvDTO(R.drawable.img3,"이름", "ㅇㄴ", "ㄴㅇ", "ㄴㅇㄹ"));
        Relist.add(new RecvDTO(R.drawable.img4,"이름", "ㅇㄴ", "ㄴㅇ", "ㄴㅇㄹ"));
        Relist.add(new RecvDTO(R.drawable.img5,"이름", "ㅇㄴ", "ㄴㅇ", "ㄴㅇㄹ"));


        recv.setAdapter(new AdapterRecv(inflater, Relist));
        recv.setLayoutManager(new LinearLayoutManager(getContext()));

        return v;
    }
}