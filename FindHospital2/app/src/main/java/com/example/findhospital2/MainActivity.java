package com.example.findhospital2;

import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.app.Activity;
import android.content.Intent;




public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        Log.i("LogTest_MainActivity","onCreate()"); //1번 흐름

        setContentView(R.layout.activity_main);




        findViewById(R.id.btnMap).setOnClickListener(this);
        findViewById(R.id.btnCost).setOnClickListener(this);
        findViewById(R.id.btnHome).setOnClickListener(this);
        findViewById(R.id.btnInfo).setOnClickListener(this);
        findViewById(R.id.btnMypage).setOnClickListener(this);

        onFragmentChange(0);

/*

        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);

        if(pref != null){
            pref.getString("name","");     // name이 없으면  "" 를 달라
            String name = pref.getString("name","");

            Toast.makeText(this, name, Toast.LENGTH_LONG).show();

        }
*/

        // 여기서 알수 있는것들 ->
        /* 화면이 중지 되는 시점-> Key , '비급여 항목을 검색해보세요'가 저장 된다 -> 그럼 다시 실행을 하면
        onResume()이 실행되는데, '안녕하세요' 라고 뜨는지 확인
         */


/*

        // 저장할때와 복구할떄 동일한 이름으로 사용해야 한다.
        // 속성을 보면 보통 Activity.MODE_PRIVATE 를 쓴다

        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);

        // Activity.MODE_PRIVATE는 SharedPreferences객체 리턴
        // pref 으로 값을 저장 할 수 있다.

        SharedPreferences.Editor editor = pref.edit();      // edit()는 editer라는 객체가 나오게된다
        //editor라는 변수를 만들면 (해쉬 테이블과 비슷하다) put,get으로 빼준다


        editor.putString("name","비급여 항목을 검색해보세요");
        editor.commit();        // commit()을 해주어야 값이 저장된다.
*/

        Toast.makeText (this, "비급여 항목을 검색해보세요",Toast.LENGTH_SHORT).show();



    }


    @Override
    public void onClick(View v){

        switch(v.getId()){
            case R.id.btnMap:


                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new Map())
                        .addToBackStack(null)
                        .commit();
                break;

            case R.id.btnCost:


                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new Cost())
                        .addToBackStack(null)
                        .commit();
                break;

            case R.id.btnHome:


                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new Home())
                        .addToBackStack(null)
                        .commit();
                break;

            case R.id.btnInfo:

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new Info())
                        .addToBackStack(null)
                        .commit();
                break;

            case R.id.btnMypage:


                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new MyPage())
                        .addToBackStack(null) //BackButton 눌렀을 때 이전 fragment로 돌아가기 위한 함수
                        .commit();
                break;


        }
    }


    public void onFragmentChange(int index){
        if(index == 0){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home()).commit();
        }
    }



    @Override
    protected void onRestart() {  //11번 흐름 - 22번 흐름(재시작됨 - 29 -35 -41 -48- 54(53-54 : 액티비티 - 프레그먼트로 이동시)
        super.onRestart();
        Log.i("LogTest_MainActivity","onRestart()");


    }


    @Override
    protected void onStart() { //3번 흐름 - 12번 흐름 - 23번 흐름(시작됨 - 30 - 36 -42 - 49 - 55
        super.onStart();
        Log.i("LogTest_MainActivity","onStart()");


    }


    @Override
    protected void onResume() { //4번 흐름 -13번 흐름 - 24번 흐름 - 31 - 37 - 43 -50 - 56 - 63(63~65 : Logain_activity - mainActivity)
        super.onResume();

        Log.i("LogTest_MainActivity","onResume()");



    }

    @Override
    protected void onPause() { //5번 흐름 - 16번 흐름 - 20번 흐름(새로운 액티비티로 들어가고난 후 얼마이후 진행됨, 이전 액티비티는 멈추고) - 27 - 33 -39 - 46 - 51 - 57
        super.onPause();



    }


    public void saveData(){


    }

    @Override
    protected void onStop() { //9번 흐름 - 17번 흐름 - 21번 흐름(새로운 액티비티로 들어가고난 후 얼마이후 진행됨, 이전 액티비티는 멈췄다가 스톱됨) - 28 - 34 - 40 -47 - 53(53-58 : 액티비티 - 프레그먼트로 이동시) -58 - 60
        super.onStop();
        Log.i("LogTest_MainActivity","onStop()");

    }





    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LogTest_MainActivity","onDestroy()");



        Toast.makeText (this, "앱이 종료되었습니다.",Toast.LENGTH_SHORT).show();


    }

}
