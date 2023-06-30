package com.example.project01_kghtalk.exam;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

public class KghAdapter extends KghAdapterParent.KghAdapter<KghAdapter.ViewHolder>{


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder() {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends KghAdapterParent.KghViewHolder{

        public ViewHolder(@NonNull View view) {
            super(view);
        }
    }


}
