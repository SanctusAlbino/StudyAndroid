package com.example.and09_fragmentadapter.Practice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.and09_fragmentadapter.R;
import com.example.and09_fragmentadapter.recyler.AdapterRecv;

import java.util.ArrayList;


public class MelonFragment extends Fragment {

    RecyclerView recv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_melon, container, false);
        recv = v.findViewById(R.id.recv);
        ArrayList<MelonDTO> mlist = getlist();
        ArrayList<MelonPractice> mlist2  = new ArrayList<>();
        AdapterMelonView am = new AdapterMelonView(inflater,mlist);



        recv.setAdapter(am);
        recv.setLayoutManager(new LinearLayoutManager(getContext()));









        return v;
    }

    ArrayList<MelonDTO> getlist() {
        ArrayList<MelonDTO> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {


            list.add(new MelonDTO(R.drawable.chart_img1, 1, "노래", "가수"));
            list.add(new MelonDTO(R.drawable.chart_img2, 2, "노래", "가수"));
            list.add(new MelonDTO(R.drawable.chart_img3, 3, "노래", "가수"));
            list.add(new MelonDTO(R.drawable.chart_img4, 4, "노래", "가수"));
            list.add(new MelonDTO(R.drawable.chart_img5, 5, "노래", "가수"));
        }
        return list;
    }
}