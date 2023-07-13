package com.example.project02_lastproject.customer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02_lastproject.common.CommonConn;
import com.example.project02_lastproject.databinding.ItemRecvCustomerBinding;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder> {
    ArrayList<CustomerVO> list;

    public CustomerAdapter(ArrayList<CustomerVO> list) {
        this.list = list;
    }
    Context context;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ItemRecvCustomerBinding binding = ItemRecvCustomerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.binding.tvId.setText(list.get(i).getId()+"");
        h.binding.tvName.setText(list.get(i).getName());
        h.binding.btnUpdate.setOnClickListener(v->{
            CustomerDialog dialog = new CustomerDialog(context, list.get(i));
            dialog.show();
        });


        h.binding.btnDelete.setOnClickListener(v->{
            //삭제 버튼을 누르면 db에 젒고해서 삭젤처리 되어야 한다.
            CommonConn conn = new CommonConn(context, "delete.cu");
            conn.addParamMap("id", list.get(i).getId());
            conn.onExcute(new CommonConn.AbCallBack() {
                @Override
                public void onResult(boolean isResult, String data) {

                }
            });
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemRecvCustomerBinding binding;
        public ViewHolder(@NonNull ItemRecvCustomerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
