package com.example.project02_lastproject.employees;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02_lastproject.databinding.ItemRecvEmpBinding;

import java.util.ArrayList;

public class EmpAdapter extends RecyclerView.Adapter<EmpAdapter.ViewHolder>{
    ArrayList<EmployeeVO> list;

    public EmpAdapter (ArrayList<EmployeeVO> list){
        this.list = list;
    }

    Context context;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ItemRecvEmpBinding binding = ItemRecvEmpBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.binding.tvEid.setText(list.get(i).getEmployee_id()+"");
        h.binding.tvEname.setText(list.get(i).getName());
        h.binding.tvEmail.setText(list.get(i).getEmail());
        h.binding.tvPhone.setText(list.get(i).getPhone_number());
        h.binding.tvHire.setText(list.get(i).getHire_date());
        h.binding.tvSalary.setText(list.get(i).getSalary());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ItemRecvEmpBinding binding;

        public ViewHolder(@NonNull ItemRecvEmpBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
