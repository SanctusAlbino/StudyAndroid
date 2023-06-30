package com.example.oliveyoung.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.oliveyoung.MainActivity;
import com.example.oliveyoung.R;
import com.example.oliveyoung.databinding.FragmentHomeBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        binding.viewPager2Container.setAdapter(new HomeAdapter(getActivity() , getFragmentList()));
//
//        binding.tabs.addTab(binding.tabs.newTab().setText("홈"));
//        binding.tabs.addTab(binding.tabs.newTab().setText("오특"));
//        binding.tabs.addTab(binding.tabs.newTab().setText("신상"));
//        binding.tabs.addTab(binding.tabs.newTab().setText("랭킹"));
//        binding.tabs.addTab(binding.tabs.newTab().setText("기획전"));
//        binding.tabs.addTab(binding.tabs.newTab().setText("이벤트"));
        final List<String> tabElement = Arrays.asList("홈","오특","신상","랭킹","기획전","이벤트");
        new TabLayoutMediator(binding.tabs, binding.viewPager2Container, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
             //   TextView textView = new TextView(getContext());

             //   textView.setText(binding.tabs.selectTab(tab));
            //    tab.setCustomView(textView);
                TextView textView = new TextView(getContext());
                textView.setText(tabElement.get(position));
                tab.setCustomView(textView);
            }
        }).attach();
        return binding.getRoot();
    }

    ArrayList<Fragment> getFragmentList(){
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new Home_1stFragment());
        list.add(new Home_2ndFragment());
        list.add(new Home_2ndFragment());
        list.add(new Home_2ndFragment());
        list.add(new Home_2ndFragment());
        list.add(new Home_2ndFragment());
        return list;
    }

}