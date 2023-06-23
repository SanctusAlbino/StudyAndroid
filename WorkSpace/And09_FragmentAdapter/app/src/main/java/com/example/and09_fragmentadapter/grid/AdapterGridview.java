package com.example.and09_fragmentadapter.grid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.and09_fragmentadapter.R;
import com.example.and09_fragmentadapter.listv.ListDTO;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterGridview extends BaseAdapter {

    LayoutInflater inflater;

    public AdapterGridview(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.item_gridview, parent, false);






        return convertView;
    }
    //뷰홀더라는것을 강제한다. (위젯을 한번찾거나 이미 붙여진칸의 경우에는 처음부터 디자인 작업을 다시하는게 아니라)
    //이미 붙어진것을 "재활용"한다.
    public class ViewHolder {
        // item_listview에 있는 모든 위젯을 찾아서 넣어둠. (초기화)
        ImageView imgv ;
        TextView tv_name;

        View v;

        public ViewHolder(View v) {
            this.v = v;
            imgv = v.findViewById(R.id.imgv);
        }
    }

}
