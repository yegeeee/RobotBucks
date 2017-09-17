package com.example.yeji.robotbucks;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class ProgressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

//        ListView listView=(ListView)findViewById(R.id.listview_progress);
//        ArrayList<ProgressListviewitem> data=new ArrayList<>();
//
//        ProgressListviewitem order = new ProgressListviewitem(R.drawable.gray_circle, "Coffee Ordered");
//        ProgressListviewitem preparing = new ProgressListviewitem(R.drawable.gray_circle, "Coffee Preparing");
//        ProgressListviewitem delivering = new ProgressListviewitem(R.drawable.gray_circle, "Coffee Delievering");
//        ProgressListviewitem finished = new ProgressListviewitem(R.drawable.gray_circle, "Order finished");
//        data.add(order);
//        data.add(preparing);
//        data.add(delivering);
//        data.add(finished);
//
//        ProgressListviewAdapter adapter=new ProgressListviewAdapter(this,R.layout.listview_progess, data);
//        listView.setAdapter(adapter);

    }
}