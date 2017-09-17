package com.example.yeji.robotbucks;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton login_btn = (ImageButton) findViewById(R.id.user);
        login_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                }
        );

        ImageButton menu_btn = (ImageButton) findViewById(R.id.coffeeButton);
        menu_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                        startActivity(intent);
                    }
                }
        );

        ImageButton robot_btn = (ImageButton) findViewById(R.id.robotButton);
        robot_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        View layout = inflater.inflate(R.layout.popup_layout, (ViewGroup) findViewById(R.id.popup_content));

                        final PopupWindow pwindo = new PopupWindow(layout, RelativeLayout.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
                        pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
                        pwindo.setFocusable(true);
                        pwindo.setOutsideTouchable(true);

                        Button btn_yes = (Button) layout.findViewById(R.id.popup_yes);

                        btn_yes.setOnClickListener(
                               new Button.OnClickListener(){
                                   public void onClick(View v){
                                       Intent intent = new Intent(MainActivity.this, RobotActivity.class);
                                       startActivity(intent);
                                   }
                               }
                        );

                        Button btn_no = (Button) layout.findViewById(R.id.popup_no);

                        btn_no.setOnClickListener(
                                new Button.OnClickListener(){
                                    public void onClick(View v){
                                        pwindo.dismiss();
                                    }
                                }
                        );
                    }
                }
        );
    }

        public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
