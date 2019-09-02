package com.example.findhospital2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Position extends AppCompatActivity {

    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position);

        Intent intent = new Intent(this.getIntent());

        btnBack = (ImageButton)findViewById(R.id.btnBack) ;
        btnBack.setBackgroundResource(R.drawable.back);

        Log.i("LogTest_Position","                 onCreate()");


        //버튼 이벤트 추가
        btnBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                cancelAction(v);


            }

        });


    }


    public void cancelAction(View v){

        finish();
    }

}
