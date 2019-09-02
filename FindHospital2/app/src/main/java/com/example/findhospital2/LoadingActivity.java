package com.example.findhospital2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class LoadingActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) { //액티비티가 처음 실행될때 onCreate() 메소드 호출
        super.onCreate(savedInstanceState);

        Log.i("LogTest_LoadingActivity","   onCreate()"); //6번 흐름

        setContentView(R.layout.activity_loading);



    }




    @Override
    protected void onStart() { //이후 onStart()
        super.onStart();

        Log.i("LogTest_LoadingActivity","   onStart()"); //7번 흐름

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(getBaseContext(), MainActivity.class);

                startActivity(intent);

                finish();
            }
        },3000);

    }


    @Override
    protected void onResume() {

        // 액티비티는 paused나 stopped상태에서도 메모리에 액티비티의 상태를 나타내는 데이터들을 가지고 있다.
        // 따라서, 다시 resume상태가 되면 paused나 stopped상태가 되기 전과 같은 상태가 되는 것


        super.onResume();


        Log.i("LogTest_LoadingActivity","   onResume()"); //8번 흐름


    }

    @Override
    protected void onPause() { //10번 흐름
        super.onPause();

        Log.i("LogTest_LoadingActivity","   onPause()");


    }

    @Override
    protected void onStop() { //14번 흐름
        super.onStop();

        Log.i("LogTest_LoadingActivity","   onStop()");

    }

    @Override
    protected void onDestroy() { //15번 흐름
        super.onDestroy();

        Log.i("LogTest_LoadingActivity","   onDestroy()");

      // finish();

    }
}