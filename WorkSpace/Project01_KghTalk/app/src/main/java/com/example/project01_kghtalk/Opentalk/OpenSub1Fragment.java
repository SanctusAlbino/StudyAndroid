package com.example.project01_kghtalk.Opentalk;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_kghtalk.R;
import com.example.project01_kghtalk.databinding.FragmentOpenSub1Binding;
import com.example.project01_kghtalk.friend.FriendAdapter;
import com.example.project01_kghtalk.friend.FriendDTO;

import java.util.ArrayList;


public class OpenSub1Fragment extends Fragment {


    FragmentOpenSub1Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding =FragmentOpenSub1Binding.inflate(inflater, container, false);

        binding.recv1Open.setAdapter(new OpenRecv1Adapter(getList(),inflater));
        binding.recv1Open.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.recv2Open.setAdapter(new OpenRecv2Adapter());
        binding.recv2Open.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.recv3Open.setAdapter(new OpenRecv3Adapter(list(),inflater));
        binding.recv3Open.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        return binding.getRoot();
    }

    public ArrayList<OpenDTO> getList(){
        ArrayList<OpenDTO> list = new ArrayList<>();
        list.add(new OpenDTO(R.drawable.img1, "ㅐㅐ방", "99명"));
        list.add(new OpenDTO(R.drawable.img2, "ㅁㅁ방", "70명"));
        list.add(new OpenDTO(R.drawable.img3, "ㅠㅠ방", "15명"));
        list.add(new OpenDTO(R.drawable.img4, "ㄴㅇㄹㅇ너ㅣㅏㄴ어ㅣ", "ㄴㅁ아ㅓ"));
        list.add(new OpenDTO(R.drawable.img5, "ㄴㅇㄹㅇ너ㅣㅏㄴ어ㅣ", "ㄴㅁ아ㅓ"));
        return list;
    }

    public ArrayList<Open2DTO> list(){
        ArrayList<Open2DTO> list2 = new ArrayList<>();
        list2.add(new Open2DTO(R.drawable.img9, "자바 소통방", "15명"));
        list2.add(new Open2DTO(R.drawable.img8, "안드 소통방", "115명"));
        list2.add(new Open2DTO(R.drawable.img7, "DB 소통방", "12명"));
        list2.add(new Open2DTO(R.drawable.img6, "잡담 소통방", "35명"));

        return list2;
    }

}