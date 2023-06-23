package com.example.and09_fragmentadapter.Practice;

import android.widget.ImageButton;
import android.widget.TextView;

public class MelonDTO {
    private int imgm, tv_num;

    private String tv_title, tv_group;

    public int getImgm() {
        return imgm;
    }

    public void setImgm(int imgm) {
        this.imgm = imgm;
    }

    public int getTv_num() {
        return tv_num;
    }

    public void setTv_num(int tv_num) {
        this.tv_num = tv_num;
    }




    public String getTv_title() {
        return tv_title;
    }

    public void setTv_title(String tv_title) {
        this.tv_title = tv_title;
    }

    public String getTv_group() {
        return tv_group;
    }

    public void setTv_group(String tv_group) {
        this.tv_group = tv_group;
    }

    public MelonDTO(int imgm, int tv_num, String tv_title, String tv_group) {
        this.imgm = imgm;
        this.tv_num = tv_num;

        this.tv_title = tv_title;
        this.tv_group = tv_group;
    }
}
