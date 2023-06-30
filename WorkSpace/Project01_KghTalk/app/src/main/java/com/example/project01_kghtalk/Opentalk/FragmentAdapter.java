package com.example.project01_kghtalk.Opentalk;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class FragmentAdapter extends FragmentStateAdapter {
    //FragmentStateAdapter <= 플래그먼트와 viewPager2 & Recy

    ArrayList<Fragment> list;

    public FragmentAdapter(@NonNull Fragment fragment, ArrayList<Fragment> list) {
        super(fragment);
        this.list =list;
    }


    @NonNull
    @Override
    public Fragment createFragment(int i) {
        return list.get(i);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
