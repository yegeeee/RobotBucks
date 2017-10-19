package com.example.yeji.robotbucks;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class MenuActivity extends AppCompatActivity {

    private ListView listview;
    private CustomChoiceListViewAdapter adapter;
    private EditText et;
    private String table_info;
    private int table_num;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference table_ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        // Adapter 생성
        adapter = new CustomChoiceListViewAdapter();

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.americano),
                "Americano");
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.caffelatte),
                "Caffelatte");
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.tea),
                "Tea");
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.fra),
                "Frappuccino");

        Button order_btn = (Button) findViewById(R.id.order_btn);
        order_btn.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        ShowDialog();
                    }
                }
        );

    }

    private void ShowDialog() {
        LayoutInflater dialog = LayoutInflater.from(this);
        final View dialogLayout = dialog.inflate(R.layout.tablepopup_layout, null);
        final Dialog myDialog = new Dialog(this);

        myDialog.setContentView(dialogLayout);
        myDialog.show();

        et = (EditText) dialogLayout.findViewById(R.id.popup_table_num);
        Button enter_btn = (Button) dialogLayout.findViewById(R.id.enter_btn);

        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.showSoftInput(et, 0);

        enter_btn.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        table_num = Integer.parseInt(et.getText().toString());

                        switch (table_num) {
                            case 1:
                                table_info = "table1";
                                table_ref = databaseReference.child("table").child("table1");
                                break;
                            case 2:
                                table_info = "table2";
                                table_ref = databaseReference.child("table").child("table2");
                                break;
                            case 3:
                                table_info = "table3";
                                table_ref = databaseReference.child("table").child("table3");
                                break;
                        }

                        setOrder();

                        listview.clearChoices();
                        adapter.notifyDataSetChanged();

                        Intent intent = new Intent(MenuActivity.this, ProgressActivity.class);
                        intent.putExtra("table_info", table_info);
                        startActivity(intent);

                    }
                }
        );
    }

    public void setOrder() {

        table_ref.child("status").setValue(1);

        long now = System.currentTimeMillis();
        Date date = new Date(now);
        databaseReference.child("table").child(table_info).child("time").setValue(date.getHours() + ":" + date.getMinutes());

        SparseBooleanArray checkedItems = listview.getCheckedItemPositions();
        int count = adapter.getCount();

        for (int i = 0; i <= count - 1; i++) {
            if (checkedItems.get(i)) {
                switch (i) {
                    case 0:
                        table_ref.child("order").child("americano").setValue(1);
                        break;
                    case 1:
                        table_ref.child("order").child("caffe latte").setValue(1);
                        break;
                    case 2:
                        table_ref.child("order").child("frappuccino").setValue(1);
                        break;
                    case 3:
                        table_ref.child("order").child("icetea").setValue(1);
                        break;
                }
            }
        }
    }
}
