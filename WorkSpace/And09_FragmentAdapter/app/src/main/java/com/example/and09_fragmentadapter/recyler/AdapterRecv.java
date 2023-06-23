package com.example.and09_fragmentadapter.recyler;


import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and09_fragmentadapter.R;

import java.util.ArrayList;

// 2. extends로 AdapterClass를 상속받는다.
//상속을 받을 때 ViewHolder가 필요함.
public class AdapterRecv extends RecyclerView.Adapter<AdapterRecv.KghViewHoder>{

    LayoutInflater inflater;

    ArrayList<RecvDTO> Relist;

    public AdapterRecv(LayoutInflater inflater, ArrayList<RecvDTO> relist) {
        this.inflater = inflater;
        Relist = relist;
    }


    // 레이아웃을 붙이고 (View) 해당하는 타입으로 ViewHolder를 만들어내는 과정의 메소드
    @NonNull
    @Override
    public KghViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recv, parent, false);

        return new KghViewHoder(v);
    }

    // ViewHolder와 Data연결 (디자인 <=> ArrayList)
    @Override
    public void onBindViewHolder(@NonNull KghViewHoder holder, int i) {
        holder.imgv.setImageResource(Relist.get(i).getImgv());
        holder.tv_nameg.setText(Relist.get(i).getTv_nameg());
        holder.tv_nameg1.setText(Relist.get(i).getTv_nameg1());
        holder.tv_nameg2.setText(Relist.get(i).getTv_nameg2());
        holder.tv_nameg3.setText(Relist.get(i).getTv_nameg3());
    }

    //총 아이템의 갯수
    @Override
    public int getItemCount() {
        return Relist.size();
    }

    //1. InnerClass로 ViewHolder를 먼저 만든다.
    // 위젯들을 묶어놓은 DTO라고 생각하면됨. 리사이클러뷰는 ViewHolder를 강제한다. (재활용)
    //ViewHolder는 일반 InnerClass에 RecycleView.ViewHolder를 상속받은 구조.
    public class KghViewHoder extends RecyclerView.ViewHolder{
        ImageView imgv;
        TextView tv_nameg, tv_nameg1, tv_nameg2, tv_nameg3;
        Button btn_detail;
        public KghViewHoder(@NonNull View v) {
            super(v);
            imgv = v.findViewById(R.id.imgv);
            tv_nameg = v.findViewById(R.id.tv_nameg);
            tv_nameg1 = v.findViewById(R.id.tv_nameg1);
            tv_nameg2 = v.findViewById(R.id.tv_nameg2);
            tv_nameg3 = v.findViewById(R.id.tv_nameg3);
            btn_detail = v.findViewById(R.id.btn_detail);
        }

    }

}
