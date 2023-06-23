package com.example.and09_fragmentadapter.listv;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.and09_fragmentadapter.R;

import java.util.ArrayList;


public class ListFragment extends Fragment {

    ListView listv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        ArrayList<ListDTO> list = new ArrayList<>();
        list.add(new ListDTO(R.drawable.img1, "이름1", "ㅇㄹ"));
        list.add(new ListDTO(R.drawable.img2, "이름2", "ㅇd"));
        list.add(new ListDTO(R.drawable.img3, "이름3", "ㅇsd"));
        list.add(new ListDTO(R.drawable.img4, "이름4", "ㅇad"));
        list.add(new ListDTO(R.drawable.img5, "이름5", "ㅇadf"));
        list.add(new ListDTO(R.drawable.img1, "이름1", "ㅇㄹ"));
        list.add(new ListDTO(R.drawable.img2, "이름2", "ㅇㄹ"));
        list.add(new ListDTO(R.drawable.img3, "이름3", "ㅇㄹ"));
        list.add(new ListDTO(R.drawable.img4, "이름4", "ㅇㄹ"));
        list.add(new ListDTO(R.drawable.img5, "이름5", "ㅇㄹ"));



        listv = v.findViewById(R.id.listv);
        AdapterListView adapter = new AdapterListView(inflater, list);
        listv.setAdapter(adapter);

        return v;
    }
}