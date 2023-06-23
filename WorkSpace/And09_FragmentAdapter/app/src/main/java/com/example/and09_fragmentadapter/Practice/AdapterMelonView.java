package com.example.and09_fragmentadapter.Practice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and09_fragmentadapter.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class AdapterMelonView extends RecyclerView.Adapter<AdapterMelonView.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<MelonDTO> mlist;

    public AdapterMelonView(LayoutInflater inflater, ArrayList<MelonDTO> mlist) {
        this.inflater = inflater;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_melon, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgm.setImageResource(mlist.get(position).getImgm());
        holder.tv_num.setText(mlist.get(position).getTv_num()+"");
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgm;
        TextView tv_num, tv_title, tv_group;
        ImageButton play_img;


        public ViewHolder(@NonNull View v) {
            super(v);
            imgm = v.findViewById(R.id.imgm);
            tv_num =v.findViewById(R.id.tv_num);
        }
    }


}
