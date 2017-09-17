package com.example.yeji.robotbucks;

import android.graphics.drawable.Drawable;

/**
 * Created by yeji on 2017. 7. 5..
 */

public class ListViewItem {
    private Drawable icon ;
    private String text ;

    public void setIcon(Drawable icon) {
        this.icon = icon ;
    }
    public void setText(String text) {
        this.text = text ;
    }

    public Drawable getIcon() {
        return this.icon ;
    }

    public String getText() {
        return this.text ;
    }
}
