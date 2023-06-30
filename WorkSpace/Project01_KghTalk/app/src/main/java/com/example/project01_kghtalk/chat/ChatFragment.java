package com.example.project01_kghtalk.chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_kghtalk.R;
import com.example.project01_kghtalk.databinding.FragmentChatBinding;
import com.example.project01_kghtalk.friend.FriendAdapter;
import com.example.project01_kghtalk.friend.FriendDTO;

import java.util.ArrayList;


public class ChatFragment extends Fragment {

    FragmentChatBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentChatBinding.inflate(inflater, container,false);
        binding.recvChat.setAdapter(new ChatAdapter(getList()));
        binding.recvChat.setLayoutManager(new LinearLayoutManager(getContext()));

        return binding.getRoot();
    }

    public ArrayList<ChatDTO> getList(){
        ArrayList<ChatDTO> list = new ArrayList<>();
        list.add(new ChatDTO(R.drawable.img1, "채팅1","ㄴㅇㄹ"));
        list.add(new ChatDTO(R.drawable.img2, "채팅2","ㅈㄷㄱ"));
        list.add(new ChatDTO(R.drawable.img3, "채팅3","ㅇㅀ"));
        list.add(new ChatDTO(R.drawable.img4, "채팅4","ㄷㄱㅎ"));
        list.add(new ChatDTO(R.drawable.img5, "채팅5","ㄴㅇㄹㅊ"));
        list.add(new ChatDTO(R.drawable.img7, "채팅7","ㅇㅇㅇ"));
        list.add(new ChatDTO(R.drawable.img8, "채팅8","ㄴㄴ"));
        list.add(new ChatDTO(R.drawable.img9, "채팅9","ㅅㅈ"));
        return list;
    }



}