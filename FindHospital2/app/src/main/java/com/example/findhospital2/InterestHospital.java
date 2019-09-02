package com.example.findhospital2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class InterestHospital extends AppCompatActivity {

    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest_hospital);

        Intent intent = getIntent();

        btnBack = (ImageButton)findViewById(R.id.btnBack) ;
        btnBack.setBackgroundResource(R.drawable.back);

        Log.i("LogTest_Inte_Hospital","onCreate()");


        //버튼 이벤트 추가
        btnBack.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {

                Log.i("dd", "back 버튼");

                cancelAction(v);


            }

        });


    }


    public void cancelAction(View v){

        finish();
    }

    @Override
    protected void onRestart() {  //11번 흐름 - 22번 흐름(재시작됨 - 29 -35 -41 -48- 54(53-54 : 액티비티 - 프레그먼트로 이동시)
        super.onRestart();
        Log.i("LogTest_Inte_Hospital","                 onRestart()");
    }

    @Override
    protected void onStart() { //3번 흐름 - 12번 흐름 - 23번 흐름(시작됨 - 30 - 36 -42 - 49 - 55
        super.onStart();
        Log.i("LogTest_Inte_Hospital","                 onStart()");
    }

    @Override
    protected void onResume() { //4번 흐름 -13번 흐름 - 24번 흐름 - 31 - 37 - 43 -50 - 56 - 63(63~65 : Logain_activity - mainActivity)
        super.onResume();
        Log.i("LogTest_Inte_Hospital","                 onResume()");
    }

    @Override
    protected void onPause() { //5번 흐름 - 16번 흐름 - 20번 흐름(새로운 액티비티로 들어가고난 후 얼마이후 진행됨, 이전 액티비티는 멈추고) - 27 - 33 -39 - 46 - 51 - 57
        super.onPause();
        Log.i("LogTest_Inte_Hospital","                 onPause()");
    }

    @Override
    protected void onStop() { //9번 흐름 - 17번 흐름 - 21번 흐름(새로운 액티비티로 들어가고난 후 얼마이후 진행됨, 이전 액티비티는 멈췄다가 스톱됨) - 28 - 34 - 40 -47 - 53(53-58 : 액티비티 - 프레그먼트로 이동시) -58 - 60
        super.onStop();
        Log.i("LogTest_Inte_Hospital","                 onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LogTest_Inte_Hospital","                 onDestroy()");

       // finish();

     //   Toast.makeText (this, "관심 병원.",Toast.LENGTH_SHORT).show();

    }

}
