package com.example.project01_sbntalk.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_sbntalk.databinding.ItemOpensubRecv1Binding;

public class OpenSub1Adapter1 extends RecyclerView.Adapter<OpenSub1Adapter1.ViewHolder> {

    ItemOpensubRecv1Binding binding;
    int[] geojiImgArr;
    String[] geojiChatArr;
    String[] geojiCntArr;

    public OpenSub1Adapter1(int[] geojiImgArr, String[] chatRoomArr, String[] chatCntArr) {
        this.geojiImgArr = geojiImgArr;
        this.geojiChatArr = chatRoomArr;
        this.geojiCntArr = chatCntArr;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemOpensubRecv1Binding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.binding.imgvGeoji.setImageResource(geojiImgArr[i]);
        h.binding.tvGeojichat.setText(geojiChatArr[i]);
        h.binding.tvGeojicnt.setText(geojiCntArr[i]);
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemOpensubRecv1Binding binding;

        public ViewHolder(@NonNull ItemOpensubRecv1Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
