package com.example.yeji.robotbucks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProgressActivity extends AppCompatActivity {

    private ImageView circle1;
    private ImageView circle2;
    private ImageView circle3;
    private ImageView circle4;

    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference table_ref ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        Intent intent = getIntent();
        String table_info = intent.getStringExtra("table_info");

        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        circle1 = (ImageView) findViewById(R.id.circle1);
        circle2 = (ImageView) findViewById(R.id.circle2);
        circle3 = (ImageView) findViewById(R.id.circle3);
        circle4 = (ImageView) findViewById(R.id.circle4);

        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);


        table_ref = databaseReference.child("table").child(table_info);

        table_ref.child("status").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                int status = dataSnapshot.getValue(Integer.class);

                switch(status) {
                    case 1:
                        circle1.setImageResource(R.drawable.green_circle);
                        text1.setTextColor(getResources().getColor(R.color.colorAccent));
                        break;
                    case 2:
                        circle2.setImageResource(R.drawable.green_circle);
                        circle1.setImageResource(R.drawable.gray_circle);
                        text2.setTextColor(getResources().getColor(R.color.colorAccent));
                        text1.setTextColor(getResources().getColor(R.color.gray_text));
                        break;
                    case 3:
                        circle3.setImageResource(R.drawable.green_circle);
                        circle2.setImageResource(R.drawable.gray_circle);
                        text3.setTextColor(getResources().getColor(R.color.colorAccent));
                        text2.setTextColor(getResources().getColor(R.color.gray_text));
                        break;
                    case 4:
                        circle4.setImageResource(R.drawable.green_circle);
                        circle3.setImageResource(R.drawable.gray_circle);
                        text4.setTextColor(getResources().getColor(R.color.colorAccent));
                        text3.setTextColor(getResources().getColor(R.color.gray_text));
                        break;
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    }
}