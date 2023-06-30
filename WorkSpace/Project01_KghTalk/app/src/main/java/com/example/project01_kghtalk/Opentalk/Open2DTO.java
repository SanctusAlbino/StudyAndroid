package com.example.project01_kghtalk.Opentalk;

public class Open2DTO {
    private int open_img3;

    private String open_name3, open_aud3;

    public int getOpen_img3() {
        return open_img3;
    }

    public void setOpen_img3(int open_img3) {
        this.open_img3 = open_img3;
    }

    public String getOpen_name3() {
        return open_name3;
    }

    public void setOpen_name3(String open_name3) {
        this.open_name3 = open_name3;
    }

    public String getOpen_aud3() {
        return open_aud3;
    }

    public void setOpen_aud3(String open_aud3) {
        this.open_aud3 = open_aud3;
    }

    public Open2DTO(int open_img3, String open_name3, String open_aud3) {
        this.open_img3 = open_img3;
        this.open_name3 = open_name3;
        this.open_aud3 = open_aud3;
    }
}
