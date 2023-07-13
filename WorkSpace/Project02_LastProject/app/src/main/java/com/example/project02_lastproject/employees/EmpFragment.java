package com.example.project02_lastproject.employees;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project02_lastproject.R;
import com.example.project02_lastproject.common.CommonConn;
import com.example.project02_lastproject.customer.CustomerAdapter;
import com.example.project02_lastproject.customer.CustomerVO;
import com.example.project02_lastproject.databinding.FragmentEmployeesBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;


public class EmpFragment extends Fragment {

    FragmentEmployeesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEmployeesBinding.inflate(inflater, container,false);
        select();
        binding.swipeEmployee.setOnRefreshListener(()->{
            select();
            binding.swipeEmployee.setRefreshing(false);

        });
        return binding.getRoot();
    }

    public void select(){
        CommonConn conn = new CommonConn(getContext(), "hr/list");
        conn.onExcute((isResult, data) -> {
            ArrayList<EmployeeVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<EmployeeVO>>(){}.getType());
            Log.d("리스트 사이즈", "select: "+ list.size());
            EmpAdapter adapter = new EmpAdapter(list);
            binding.recvEmployee.setAdapter(adapter);
            binding.recvEmployee.setLayoutManager(new LinearLayoutManager(getContext()));
        });
    }
}