package com.example.llove.recyclerview;

public class chat {
    public static int jieshou = 0;
    public static int fasong = 1;
    private String xiaoxi;
    private int leixing;
    private int touxiang;

    public chat(String xiaoxi,int touxiang, int leixing) {
        this.xiaoxi = xiaoxi;
        this.leixing = leixing;
        this.touxiang = touxiang;
    }

    public chat(String xiaoxi,int leixing){
        this.xiaoxi = xiaoxi;
        this.leixing = leixing;

    }

    public static int getJieshou() {
        return jieshou;
    }

    public static void setJieshou(int jieshou) {
        chat.jieshou = jieshou;
    }

    public static int getFasong() {
        return fasong;
    }

    public static void setFasong(int fasong) {
        chat.fasong = fasong;
    }

    public String getXiaoxi() {
        return xiaoxi;
    }

    public void setXiaoxi(String xiaoxi) {
        this.xiaoxi = xiaoxi;
    }

    public int getLeixing() {
        return leixing;
    }

    public void setLeixing(int leixing) {
        this.leixing = leixing;
    }

    public int getTouxiang() {
        return touxiang;
    }

    public void setTouxiang(int touxiang) {
        this.touxiang = touxiang;
    }
}
