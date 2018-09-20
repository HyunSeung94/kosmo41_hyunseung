package com.study.android.list6;

public class SingerItem {

    private String name;
    private String Telnum;
    private int resId;

    public SingerItem(String name, String telnum, int resId) {
        this.name = name;
        Telnum = telnum;
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelnum() {
        return Telnum;
    }

    public void setTelnum(String telnum) {
        Telnum = telnum;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}