package com.example.project01_kghtalk.Opentalk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_kghtalk.databinding.ItemOpenRecv3Binding;

import java.util.ArrayList;

public class OpenRecv3Adapter extends RecyclerView.Adapter<OpenRecv3Adapter.ViewHolder> {

    ItemOpenRecv3Binding binding;
    ArrayList<Open2DTO> list;

    LayoutInflater inflater;

    public OpenRecv3Adapter(ArrayList<Open2DTO> list, LayoutInflater inflater) {
        this.list = list;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemOpenRecv3Binding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.binding.imgvChip3.setImageResource(list.get(i).getOpen_img3());
        h.binding.tv1Chip3.setText(list.get(i).getOpen_name3());
        h.binding.tv2Chip3.setText(list.get(i).getOpen_aud3());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ItemOpenRecv3Binding binding;

        public ViewHolder(@NonNull ItemOpenRecv3Binding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
