package com.namuon.fragmentchangetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_frag1).setOnClickListener(this);
        findViewById(R.id.btn_frag2).setOnClickListener(this);
        findViewById(R.id.btn_frag3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_frag1:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frag_container_, new FragmentOne())
                        .commit();
                break;
            case R.id.btn_frag2:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frag_container_, new FragmentTwo())
                        .commit();
                break;
            case R.id.btn_frag3:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frag_container_, new FragmentThree())
                        .commit();
                break;
        }
    }
}
