package com.example.findhospital;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity{

    private Button btnMap;
    private Button btnCost;
    private Button btnHome;
    private Button btnInfo;
    private Button btnMypage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Intent intent = new Intent(this.getIntent());

        btnMap = (Button)findViewById(R.id.btnMap);
        btnCost = (Button)findViewById(R.id.btnCost);
        btnHome = (Button)findViewById(R.id.btnHome);
        btnInfo = (Button)findViewById(R.id.btnInfo);
        btnMypage = (Button)findViewById(R.id.btnMypage);

        btnMap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Map.class);
                startActivity(intent);
                finish();
            }
        });

        btnCost.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Cost.class);
                startActivity(intent);
                finish();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Info.class);
                startActivity(intent);
                finish();
            }
        });

        btnMypage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyPage.class);
                startActivity(intent);
                finish();
            }
        });

    }




    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);


    }


}

