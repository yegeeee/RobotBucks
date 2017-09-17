package com.example.yeji.robotbucks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yeji on 2017. 7. 7..
 */

public class ProgressListviewAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<ProgressListviewitem> data;
    private int layout;

    public ProgressListviewAdapter(Context context, int layout, ArrayList<ProgressListviewitem> data){
        this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data=data;
        this.layout=layout;
    }
    @Override
    public int getCount(){return data.size();}
    @Override
    public String getItem(int position){return data.get(position).getName();}
    @Override
    public long getItemId(int position){return position;}
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView==null){
            convertView=inflater.inflate(layout,parent,false);
        }
        ProgressListviewitem listviewitem=data.get(position);
        ImageView icon=(ImageView)convertView.findViewById(R.id.imageView_progress);
        icon.setImageResource(listviewitem.getIcon());
        TextView name=(TextView)convertView.findViewById(R.id.textView_progress);
        name.setText(listviewitem.getName());
        return convertView;
    }
}
