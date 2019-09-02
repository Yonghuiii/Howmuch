package com.example.findhospital2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private Button btnLogin;
    private Button btnRegist;
    private Button btnPassword;

    ImageButton btnBack;


    private EditText etEmail;
    private String value;

    public static Activity LoginActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginActivity = Login.this;

        Intent intent = getIntent();

        Log.i("LogTest_Login","                 onCreate()"); //52 - 59

        btnBack = (ImageButton)findViewById(R.id.btnBack) ;
        btnBack.setBackgroundResource(R.drawable.back);

        btnBack = (ImageButton)findViewById(R.id.btnBack);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnRegist = (Button)findViewById(R.id.btnRegist);
        btnPassword = (Button)findViewById(R.id.btnPassword);




        btnRegist.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Login.this, Join.class);

                startActivity(intent);

                finish();




            }
        });

        btnPassword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Login.this, PassWord.class);

                startActivity(intent);

                finish();



            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


               finishAction();


            }
        });

        //버튼 이벤트 추가
        btnBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                finishAction();

            }

        });



    }

    public void finishAction(){

        finish();
    }


    @Override
    protected void onRestart() {  //11번 흐름 - 22번 흐름(재시작됨 - 29 -35 -41 -48- 54(53-54 : 액티비티 - 프레그먼트로 이동시)
        super.onRestart();
        Log.i("LogTest_Login","                 onRestart()");

        //회원가입, 비밀번호찾기에서 뒤로가기 누르면 restart() 로 오기 때문에 여기서 페이지를 없애줘야 함


    }

    @Override
    protected void onStart() { //3번 흐름 - 12번 흐름 - 23번 흐름(시작됨 - 30 - 36 -42 - 49 - 55
        super.onStart();
        Log.i("LogTest_Login","                 onStart()");
    }

    @Override
    protected void onResume() { //4번 흐름 -13번 흐름 - 24번 흐름 - 31 - 37 - 43 -50 - 56 - 63(63~65 : Logain_activity - mainActivity)
        super.onResume();
        Log.i("LogTest_Login","                 onResume()");
    }

    @Override
    protected void onPause() { //5번 흐름 - 16번 흐름 - 20번 흐름(새로운 액티비티로 들어가고난 후 얼마이후 진행됨, 이전 액티비티는 멈추고) - 27 - 33 -39 - 46 - 51 - 57
        super.onPause();

        Log.i("LogTest_Login","                 onPause()");



    }



    @Override
    protected void onStop() { //9번 흐름 - 17번 흐름 - 21번 흐름(새로운 액티비티로 들어가고난 후 얼마이후 진행됨, 이전 액티비티는 멈췄다가 스톱됨) - 28 - 34 - 40 -47 - 53(53-58 : 액티비티 - 프레그먼트로 이동시) -58 - 60
        super.onStop();
        Log.i("LogTest_Login","                 onStop()");


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LogTest_Login","                 onDestroy()");



    }

}
