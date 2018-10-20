package com.programmerhuntbd.bulbul.careerpathbd.webpost;

/**
 * Created by bulbul on 10/19/2018.
 */

public class Model {

    public static final int IMAGE_TYPE =1;
    public String title, subtitle, Image;
    public int type;


    public Model ( int mtype, String mtitle, String msubtitle, String image  ){

        this.title = mtitle;
        this.subtitle = msubtitle;
       this.type = mtype;
        this.Image = image;
    }

    public Model(String title, String subtitle, String image) {
        this.title = title;
        this.subtitle = subtitle;
        this.Image = image;
    }

    public Model(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }
}