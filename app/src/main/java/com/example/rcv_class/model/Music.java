package com.example.rcv_class.model;

public class Music {
    private int srcImg;
    private String name;
    private String urlMusic;



    public String getUrlMusic() {
        return urlMusic;
    }

    public void setUrlMusic(String urlMusic) {
        this.urlMusic = urlMusic;
    }

    public int getSrcImg() {
        return srcImg;
    }

    public void setSrcImg(int srcImg) {
        this.srcImg = srcImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Music(int srcImg, String name) {
        this.srcImg = srcImg;
        this.name = name;
        this.urlMusic = null;
    }
    //"https://aredir.nixcdn.com/NhacCuaTui1019/GapGoYeuDuongVaDuocBenEm-PhanManhQuynh-7061898.mp3?st=sIoqH7cD8imEmvtIUtNjvQ&e=1631635351"
    public Music(int srcImg, String name, String urlMusic) {
        this.srcImg = srcImg;
        this.name = name;
        this.urlMusic = urlMusic;
    }
}
