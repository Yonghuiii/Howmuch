package com.example.findhospital2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Map extends Fragment {

    Button btnPosition;
    Button btnCategoryTreatment;

  //  private MapView mapView = null;

    //onAttach() 콜백 메소드는 fargment가 activity에 추가되고 나면 호출
    //이때 Activity가 파라미터로 전달되게 된다.
    // Fragment는 Activity가 아니다.
    // 다시말해서 Activity는 Context를 상속받아서 Context가 있지만 Fragment는 android.app 의 Object 클래스를 상속받아서 만들어진 클래스이다.
    // 그래서 Fragment에서는 Context의 기능을 바로 사용할 수 없다.
    // 뿐만 아니라 Fragment는 Activity 안에서만 존재하기 때문에 Activity를 onAttach() 콜백으로 받아올 수 있다.


/*
    @Override
    public void onAttach(MainActivity activity) {
        super.onAttach(activity);

        Log.i("LogTest_Map","onAttach()");
    }
*/


   //Fragment의 onCreate() 메소드는 Activity의 onCreate() 메소드와 비슷하지만
   // Bundle을 받아오기 때문에 bundle에 대한 속성을 사용할 수 있다.

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Log.i("LogTest_Map","            onCreate()"); //18번 흐름
    }

    //Fragment에 실제 사용할 뷰를 만드는 작업을 하는 메소드
    //LayoutInflater를 인자로 받아서 layout으로 설정한 XML을 연결하거나 bundle에 의한 작업을 하는 메소드

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        final View view = inflater.inflate(R.layout.fragment_map,null);

        btnPosition = (Button)view.findViewById(R.id.btnPosition);
        btnCategoryTreatment = (Button)view.findViewById(R.id.btnCategoryTreatment);


/*
        mapView = (MapView)view.findViewById(R.id.map);
        mapView.getMapAsync(this);
*/
        Log.i("LogTest_Map","            onCreateView()"); //19번 흐름

        //버튼 이벤트 추가
        btnPosition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(view.getContext(), Position.class);

                view.getContext().startActivity(intent);

               //getActivity().finish();

            }
        });

        btnCategoryTreatment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){


                Intent intent = new Intent(view.getContext(), CategoryTreatment.class);

                view.getContext().startActivity(intent);

                //getActivity().finish();
            }
        });

        return view;
        //return inflater.inflate(R.layout.fragment_map, container, false);


    }


   // Activity에서 Fragment를 모두 생성하고 난 다음에 (Activity의 onCreate()가 마치고 난 다음)에 생성되는 메소드
    //이 메소드가 호출될 때에서는 Activity의 모든 View가 만들어지고 난 다음이기 때문에 View를 변경하는 등의 작업을 할 수 있다.

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        if(savedInstanceState != null) {
            for(String key : savedInstanceState.keySet()) {
                //Log.v("savedInstanceState key : " + key);
            }
        }

        super.onActivityCreated(savedInstanceState);

        Log.i("LogTest_Map","              onActivityCreated()");

        // 뷰에 데이터를 넣는 작업 등을 할 추가할 수 있음
    }


   //이 메소드가 호출되면 화면의 모든 UI가 만들어지고 호출이 된다
    @Override
    public void onStart() {
        super.onStart();

        Log.i("LogTest_Map","             onStart()");

        //mapView.onStart();

    }

    //이 메소드가 호출되고 난 다음에 사용자와 Fragment와 상호작용이 가능하다. 다시 말해서 이 곳에서 사용자가 버튼을 누르거나 하는 이벤트를 받을 수 있게 된다.
    @Override
    public void onResume() {
        super.onResume();

        Log.i("LogTest_Map","              onResume()");

        //mapView.onStop();

    }

    @Override
    public void onPause() {
        super.onPause();

        Log.i("LogTest_Map","             onPause()");

    }

    //이 메소드에서는 Activity와 동일하게 Fragment가 사라질때 현재의 상태를 저장하고 나중에 Fragment가 돌아오면 다시 저장한 내용을 사용할 수 있게해주는 메소드이다.
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        //savedInstanceState.putInt("text", "savedText");

        Log.i("LogTest_Map","             onSaveInstanceState()");

        //mapView.onSaveInstanceState(outState);

    }

    //Fragment의 onStop() 메소드는 Activity의 onStop()메소드와 비슷하다.
    //이 콜백 메소드가 호출되면 Fragment가 더이상 보이지 않는 상태이고 더이상 Activity에서 Fragment에게 오퍼레이션을 할 수 없게 된다.
    @Override
    public void onStop() {
        super.onStop();

        Log.i("LogTest_Map","             onStop()");

    }

    //Fragment의 View가 모두 소멸될 때 호출되는 콜백 메소드이다.
    // 이때 View에 관련된 모든 자원들이 사라지게 된다.
    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.i("LogTest_Map","             onDestroyView()");

    }

    //Fragment를 더이상 사용하지 않을 때 호출되는 콜백 메소드이다.
    // 하지만 Activity와의 연결은 아직 끊어진 상태는 아니다.
    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i("LogTest_Map","             onDestroy()");

    }

    //Fragment가 더이상 Activity와 관계가 없을 때 두 사이의 연결을 끊으며
    // Fragment에 관련된 모든 자원들이 사라지게 된다.

    @Override
    public void onDetach() {
        super.onDetach();
        //activity = null;

        Log.i("LogTest_Map","            onDetach()");

        getActivity().finish();

        Toast.makeText (getContext(), "앱이 종료되었습니다.",Toast.LENGTH_SHORT).show();

    }

}
