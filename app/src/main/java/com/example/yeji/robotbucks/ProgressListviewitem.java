package com.example.yeji.robotbucks;

/**
 * Created by yeji on 2017. 7. 7..
 */

public class ProgressListviewitem {
    private int icon;
    private String name;
    public int getIcon(){return icon;}
    public String getName(){return name;}

    public ProgressListviewitem(int icon, String name){
        this.icon=icon;
        this.name=name;
    }

    public void changeToGray(){
        this.icon = R.drawable.gray_circle;
    }

    public void changeToGreen(){
        this.icon = R.drawable.green_circle;
    }

}
