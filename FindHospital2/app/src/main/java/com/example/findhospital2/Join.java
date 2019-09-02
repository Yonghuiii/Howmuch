package com.example.findhospital2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class Join extends AppCompatActivity {


    private Button btnJoinFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        Log.i("LogTest_Join","                  onCreate()"); //61(59~61 : 액티비티 - 액티비티)


        setContentView(R.layout.activity_join);

        btnJoinFinish = (Button)findViewById(R.id.btnJoinFinish);

        //버튼 이벤트 추가
        btnJoinFinish.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Join.this, Login.class);

                startActivity(intent);

                finish();

            }

        });


    }



    @Override
    protected void onStart() { //3번 흐름 - 12번 흐름 - 23번 흐름(시작됨 - 30 - 36 -42 - 49 - 55
        super.onStart();

        Log.i("LogTest_Join","                  onStart()");


    }

    @Override
    protected void onResume() { //4번 흐름 -13번 흐름 - 24번 흐름 - 31 - 37 - 43 -50 - 56 - 63(63~65 : Logain_activity - mainActivity)
        super.onResume();
        Log.i("LogTest_Join","                  onResume()");
    }

    @Override
    protected void onPause() { //5번 흐름 - 16번 흐름 - 20번 흐름(새로운 액티비티로 들어가고난 후 얼마이후 진행됨, 이전 액티비티는 멈추고) - 27 - 33 -39 - 46 - 51 - 57
        super.onPause();
        Log.i("LogTest_Join","                  onPause()");


       // Toast.makeText (this, "회원가입되었습니다.",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() { //9번 흐름 - 17번 흐름 - 21번 흐름(새로운 액티비티로 들어가고난 후 얼마이후 진행됨, 이전 액티비티는 멈췄다가 스톱됨) - 28 - 34 - 40 -47 - 53(53-58 : 액티비티 - 프레그먼트로 이동시) -58 - 60
        super.onStop();
        Log.i("LogTest_Join","                  onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LogTest_Join","                  onDestroy()");




    }
}
