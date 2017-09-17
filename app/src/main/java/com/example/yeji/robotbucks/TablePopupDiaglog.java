package com.example.yeji.robotbucks;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by yeji on 2017. 9. 15..
 */

public class TablePopupDiaglog extends Dialog {

    private EditText et;
    private Button Enter_btn;

    private int tablenum;

    private View.OnClickListener enterbtnListener;

    public TablePopupDiaglog (Context context){
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
//        this.enterbtnListener = singleListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablepopup_layout);

        // 다이얼로그 외부 화면 흐리게 표현
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        et = (EditText) findViewById(R.id.popup_table_num);
        Enter_btn = (Button) findViewById(R.id.enter_btn);

        Enter_btn.setOnClickListener(enterbtnListener);
    }

}
