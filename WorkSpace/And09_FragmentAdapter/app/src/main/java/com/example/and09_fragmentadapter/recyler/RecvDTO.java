package com.example.and09_fragmentadapter.recyler;

public class RecvDTO {
    private int imgv;

    private String tv_nameg, tv_nameg1, tv_nameg2, tv_nameg3;

    public int getImgv() {
        return imgv;
    }

    public void setImgv(int imgv) {
        this.imgv = imgv;
    }

    public String getTv_nameg() {
        return tv_nameg;
    }

    public void setTv_nameg(String tv_nameg) {
        this.tv_nameg = tv_nameg;
    }

    public String getTv_nameg1() {
        return tv_nameg1;
    }

    public void setTv_nameg1(String tv_nameg1) {
        this.tv_nameg1 = tv_nameg1;
    }

    public String getTv_nameg2() {
        return tv_nameg2;
    }

    public void setTv_nameg2(String tv_nameg2) {
        this.tv_nameg2 = tv_nameg2;
    }

    public String getTv_nameg3() {
        return tv_nameg3;
    }

    public void setTv_nameg3(String tv_nameg3) {
        this.tv_nameg3 = tv_nameg3;
    }

    public RecvDTO(int imgv, String tv_nameg, String tv_nameg1, String tv_nameg2, String tv_nameg3) {
        this.imgv = imgv;
        this.tv_nameg = tv_nameg;
        this.tv_nameg1 = tv_nameg1;
        this.tv_nameg2 = tv_nameg2;
        this.tv_nameg3 = tv_nameg3;
    }
}
