package com.example.and09_fragmentadapter.Practice;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MelonPractice {

    private ImageView me_img;

    private TextView me_num, me_title, me_group;

    private ImageButton me_img_btn;

    public ImageView getMe_img() {
        return me_img;
    }

    public void setMe_img(ImageView me_img) {
        this.me_img = me_img;
    }

    public TextView getMe_num() {
        return me_num;
    }

    public void setMe_num(TextView me_num) {
        this.me_num = me_num;
    }

    public TextView getMe_title() {
        return me_title;
    }

    public void setMe_title(TextView me_title) {
        this.me_title = me_title;
    }

    public TextView getMe_group() {
        return me_group;
    }

    public void setMe_group(TextView me_group) {
        this.me_group = me_group;
    }

    public ImageButton getMe_img_btn() {
        return me_img_btn;
    }

    public void setMe_img_btn(ImageButton me_img_btn) {
        this.me_img_btn = me_img_btn;
    }

    public MelonPractice(ImageView me_img, TextView me_num, TextView me_title, TextView me_group, ImageButton me_img_btn) {
        this.me_img = me_img;
        this.me_num = me_num;
        this.me_title = me_title;
        this.me_group = me_group;
        this.me_img_btn = me_img_btn;
    }
}
