package com.example.findhospital2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class Info extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Log.i("LogTest_Info","            onCreate()"); //18번 흐름
    }

        // fragment_main.xml 파일과 인플레이션으로 연결해주는것을 메모리 객체화를 시켜주어야한다

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            Log.i("LogTest_Info","            onCreateView()"); // 38 -


            return inflater.inflate(R.layout.fragment_info, container, false);


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        if(savedInstanceState != null) {
            for(String key : savedInstanceState.keySet()) {
                //Log.v("savedInstanceState key : " + key);
            }
        }

        super.onActivityCreated(savedInstanceState);

        Log.i("LogTest_Info","             onActivityCreated()");

        // 뷰에 데이터를 넣는 작업 등을 할 추가할 수 있음
    }


    //이 메소드가 호출되면 화면의 모든 UI가 만들어지고 호출이 된다
    @Override
    public void onStart() {
        super.onStart();

        Log.i("LogTest_Info","            onStart()");

    }

    //이 메소드가 호출되고 난 다음에 사용자와 Fragment와 상호작용이 가능하다. 다시 말해서 이 곳에서 사용자가 버튼을 누르거나 하는 이벤트를 받을 수 있게 된다.
    @Override
    public void onResume() {
        super.onResume();

        Log.i("LogTest_Info","            onResume()");

    }

    @Override
    public void onPause() {
        super.onPause();

        Log.i("LogTest_Info","            onPause()");

    }

    //이 메소드에서는 Activity와 동일하게 Fragment가 사라질때 현재의 상태를 저장하고 나중에 Fragment가 돌아오면 다시 저장한 내용을 사용할 수 있게해주는 메소드이다.
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        //savedInstanceState.putInt("text", "savedText");

        Log.i("LogTest_Info","             onSaveInstanceState()");

    }

    //Fragment의 onStop() 메소드는 Activity의 onStop()메소드와 비슷하다.
    //이 콜백 메소드가 호출되면 Fragment가 더이상 보이지 않는 상태이고 더이상 Activity에서 Fragment에게 오퍼레이션을 할 수 없게 된다.
    @Override
    public void onStop() {
        super.onStop();

        Log.i("LogTest_Info","             onStop()");

    }

    //Fragment의 View가 모두 소멸될 때 호출되는 콜백 메소드이다.
    // 이때 View에 관련된 모든 자원들이 사라지게 된다.
    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.i("LogTest_Info","             onDestroyView()");

    }

    //Fragment를 더이상 사용하지 않을 때 호출되는 콜백 메소드이다.
    // 하지만 Activity와의 연결은 아직 끊어진 상태는 아니다.
    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i("LogTest_Info","               onDestroy()");

    }

    //Fragment가 더이상 Activity와 관계가 없을 때 두 사이의 연결을 끊으며
    // Fragment에 관련된 모든 자원들이 사라지게 된다.

    @Override
    public void onDetach() {
        super.onDetach();
        //activity = null;

        Log.i("LogTest_Info","              onDetach()");

        getActivity().finish();

        Toast.makeText (getContext(), "앱이 종료되었습니다.",Toast.LENGTH_SHORT).show();

    }

}
