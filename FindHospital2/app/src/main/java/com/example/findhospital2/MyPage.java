package com.example.findhospital2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.net.Uri;
import android.widget.Toast;
import android.support.v4.content.ContextCompat;
import android.content.pm.PackageManager;
import android.Manifest;
import android.support.v4.app.ActivityCompat;



import java.io.File;
import java.io.IOException;


public class MyPage extends Fragment implements ActivityCompat.OnRequestPermissionsResultCallback{


    TextView textLogin;
    Button btnInterestCategory;
    Button btnInterestHospital;
    Button btnInterestInfo;
    Button btnMyReview;


    private static final int PICK_FROM_CAMERA = 0;
    private static final int PICK_FROM_ALBUM = 1;
    private static final int CROP_FROM_CAMERA = 2;


    private static final int REQUEST_EXTERNAL_STORAGE_AND_CAMERA_RESULT = 1;
    private static final int REQUEST_EXTERNAL_STORAGE_RESULT = 1;
    private static final int REQUEST_CAMERA_RESULT = 1;


    private ImageView imageView_profile;


    public Uri mImageCaptureUri = null;



    @Override
    public void onCreate(Bundle savedInstanceState) {

        Log.i("LogTest_MyPage", "              onCreate()"); //44

        super.onCreate(savedInstanceState);


    }

    // fragment_main.xml 파일과 인플레이션으로 연결해주는것을 메모리 객체화를 시켜주어야한다

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // 인플레이션이 가능하다, container 이쪽으로 붙여달라, fragment_main을

        final View view = inflater.inflate(R.layout.fragment_mypage, null);

        imageView_profile = (ImageView) view.findViewById(R.id.imageView_profile);
        imageView_profile.setImageResource(R.drawable.cherryblossom);

        textLogin = (TextView) view.findViewById(R.id.textLogin);
        btnInterestCategory = (Button) view.findViewById(R.id.btnInterestCategory);
        btnInterestHospital = (Button) view.findViewById(R.id.btnInterestHospital);
        btnInterestInfo = (Button) view.findViewById(R.id.btnInterestInfo);
        btnMyReview = (Button) view.findViewById(R.id.btnMyReview);





        Log.i("LogTest_MyPage", "              onCreateView()"); //45


        textLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getActivity(), Login.class);

                getActivity().startActivity(intent);

                //   ((Login)getActivity()).findViewById(R.id.textLogin);

                //   getActivity().finish();

            }


        });


        btnInterestCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getActivity(), InterestItem.class);

                getActivity().startActivity(intent);


            }
        });


        btnInterestHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(view.getContext(), InterestHospital.class);

                view.getContext().startActivity(intent);
                //   ((InterestHospital)getActivity()).findViewById(R.id.btnInterestHospital);


                //  getActivity().finish();
            }
        });


        btnInterestInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(view.getContext(), Interest_Content.class);

                view.getContext().startActivity(intent);

                //   ((Interest_Content)getActivity()).findViewById(R.id.btnInterestInfo);


                // getActivity().finish();

            }
        });


        btnMyReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(view.getContext(), MyReview.class);

                view.getContext().startActivity(intent);

                // ((MyReview)getActivity()).findViewById(R.id.btnMyReview);

                //getActivity().finish();

            }
        });

        imageView_profile.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {



                DialogInterface.OnClickListener cameraListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("LogTest_MyPage", "              카메라 시작 전"); //45


                        if(isDeviceSupportCamera()){

                            permissonControl();
                        }
                        else
                        {
                            Toast.makeText(getContext(), "Sorry! Your device doesn't support camera", Toast.LENGTH_SHORT).show();
                        }

                        Log.i("LogTest_MyPage", "              카메라 시작 후"); //45
                    }
                };
                DialogInterface.OnClickListener albumListener = new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("LogTest_MyPage", "              앨범 시작 전");

                        doTakeAlbumAction();

                        Log.i("LogTest_MyPage", "              앨범 시작 후");
                    }
                };
                DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("LogTest_MyPage", "              취소 시작 전");

                        dialog.dismiss();

                    }
                };

                new AlertDialog.Builder(getContext())
                        .setTitle("업로드할 이미지 선택")
                        .setPositiveButton("사진촬영", cameraListener)
                        .setNeutralButton("앨범선택", albumListener)
                        .setNegativeButton("취소", cancelListener)
                        .show();


            }

        });


        return view;
        //return inflater.inflate(R.layout.fragment_mypage, container, false);
        // 플래그먼트 화면으로 보이게 된다. 부분화면을 보여주고자하는 틀로 생각하면 된다.

    }

    /**
     * Checking device has camera hardware or not
     * */
    private boolean isDeviceSupportCamera() {
        return getContext().getApplicationContext().getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_CAMERA);
    }


    /**
     * Checking permisson for device
     */
    private void permissonControl() {
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {

            Toast.makeText(getContext().getApplicationContext(), "Camera permission check1", Toast.LENGTH_SHORT).show();

           doTakePhotoAction();

            Toast.makeText(getContext().getApplicationContext(), "Camera permission check2", Toast.LENGTH_SHORT).show();


        } else {
            if (shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Toast.makeText(getContext().getApplicationContext(), "External storage permission required to save images", Toast.LENGTH_SHORT).show();

            }
            if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                 Toast.makeText(getContext().getApplicationContext(), "Camera permission required to take a picture", Toast.LENGTH_SHORT).show();


            } else {
                if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                            REQUEST_EXTERNAL_STORAGE_AND_CAMERA_RESULT
                    );

                }
                if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            REQUEST_EXTERNAL_STORAGE_RESULT
                    );

                }
                if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.CAMERA},
                            REQUEST_CAMERA_RESULT
                    );


                }
            }

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_EXTERNAL_STORAGE_RESULT ){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){

                doTakePhotoAction();

                Log.i("LogTest_MyPage","권한 요청");

            }

        }
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
    }

    /**
     * 카메라에서 이미지 가져오기
     */
    private void doTakePhotoAction() {


        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        Log.i("LogTest_MyPage","               경로 설정 전");

        // Write the new photo to the user's SD Card
        File file = new File(Environment.getExternalStorageDirectory(), "snapshot" + String.valueOf(System.currentTimeMillis() + ".jpg"));


        // Get the photo's uri, 임시로 사용할 파일의 경로를 생성
        mImageCaptureUri = Uri.fromFile(file);
        // Uri providerURI = FileProvider.getUriForFile( context ,getPackageName() , photoFile);

        Log.i("LogTest_MyPage","               경로 설정 후");

        // Delegate to "onActivityResult"
        try {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, mImageCaptureUri);

            Log.i("LogTest_MyPage","               경로에 사진 넣은 후");


            startActivityForResult(intent, PICK_FROM_CAMERA);
            // startActivityForResult(Intent.createChooser(intent, "Complete action using"), PICK_FROM_CAMERA); 카메라 여러개 띄우기

            Log.i("LogTest_MyPage","               카메라로부터 사진 찍기");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i("LogTest_MyPage", "               카메라로 사진 가져오기 후");



    }


    /**
     * 앨범에서 이미지 가져오기
     */
    private void doTakeAlbumAction()
    {
        // 앨범 호출
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);

        Log.i("LogTest_MyPage","               앨범에서 사진 가져오기 전");

        startActivityForResult(intent, PICK_FROM_ALBUM);

        Log.i("LogTest_MyPage","               앨범에서 사진 가져오기 전");

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(resultCode != Activity.RESULT_OK)
        {
            return;
        }

        switch(requestCode)
        {
            case CROP_FROM_CAMERA:
            {
                // 크롭이 된 이후의 이미지를 넘겨 받습니다.
                // 이미지뷰에 이미지를 보여준다거나 부가적인 작업 이후에
                // 임시 파일을 삭제합니다.


                final Bundle extras = data.getExtras();

                Log.i("LogTest_MyPage","               카메라로 사진 자르는 중");


                if(extras != null)
                {
                    Bitmap photo = extras.getParcelable("data");
                    imageView_profile.setImageBitmap(photo);
                }

                // 임시 파일 삭제
                File f = new File(mImageCaptureUri.getPath());
                if(f.exists())
                {
                    f.delete();
                }

                break;

            }

            case PICK_FROM_ALBUM:
            {
                // 이후의 처리가 카메라와 같으므로 일단  break없이 진행합니다.
                // 실제 코드에서는 좀더 합리적인 방법을 선택하시기 바랍니다.

                Log.i("LogTest_MyPage","               앨범에서 사진 가져오는 중");

                mImageCaptureUri = data.getData();
            }

            case PICK_FROM_CAMERA:
            {
                // 이미지를 가져온 이후의 리사이즈할 이미지 크기를 결정합니다.
                // 이후에 이미지 크롭 어플리케이션을 호출하게 됩니다.

             //   mImageCaptureUri = data.getData();

                Log.i("LogTest_MyPage","               카메라로 사진 가져오는 중");

                Intent intent = new Intent("com.android.camera.action.CROP");
                intent.setDataAndType(mImageCaptureUri, "image/*");

                intent.putExtra("outputX", 90);
                intent.putExtra("outputY", 90);
                intent.putExtra("aspectX", 1);
                intent.putExtra("aspectY", 1);
                intent.putExtra("scale", true);
                intent.putExtra("return-data", true);

                startActivityForResult(intent, CROP_FROM_CAMERA);

                break;
            }
        }
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        if(savedInstanceState != null) {
            for(String key : savedInstanceState.keySet()) {
                //Log.v("savedInstanceState key : " + key);
            }
        }

        super.onActivityCreated(savedInstanceState);

        Log.i("LogTest_MyPage","              onActivityCreated()");

        // 뷰에 데이터를 넣는 작업 등을 할 추가할 수 있음
    }


    //이 메소드가 호출되면 화면의 모든 UI가 만들어지고 호출이 된다
    @Override
    public void onStart() {
        super.onStart();



        Log.i("LogTest_MyPage","               onStart()");


    }

    //이 메소드가 호출되고 난 다음에 사용자와 Fragment와 상호작용이 가능하다. 다시 말해서 이 곳에서 사용자가 버튼을 누르거나 하는 이벤트를 받을 수 있게 된다.
    @Override
    public void onResume() {
        super.onResume();


        Log.i("LogTest_MyPage","              onResume()");

    }

    @Override
    public void onPause() {
        super.onPause();

        Log.i("LogTest_MyPage","               onPause()");

    }



    //이 메소드에서는 Activity와 동일하게 Fragment가 사라질때 현재의 상태를 저장하고 나중에 Fragment가 돌아오면 다시 저장한 내용을 사용할 수 있게해주는 메소드이다.
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        //savedInstanceState.putInt("text", "savedText");


        Log.i("LogTest_MyPagep","              onSaveInstanceState()");

    }

    //Fragment의 onStop() 메소드는 Activity의 onStop()메소드와 비슷하다.
    //이 콜백 메소드가 호출되면 Fragment가 더이상 보이지 않는 상태이고 더이상 Activity에서 Fragment에게 오퍼레이션을 할 수 없게 된다.
    @Override
    public void onStop() {
        super.onStop();


        Log.i("LogTest_MyPage","              onStop()");

    }

    //Fragment의 View가 모두 소멸될 때 호출되는 콜백 메소드이다.
    // 이때 View에 관련된 모든 자원들이 사라지게 된다.
    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.i("LogTest_MyPage","               onDestroyView()");

    }

    //Fragment를 더이상 사용하지 않을 때 호출되는 콜백 메소드이다.
    // 하지만 Activity와의 연결은 아직 끊어진 상태는 아니다.
    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i("LogTest_MyPage","              onDestroy()");

    }

    //Fragment가 더이상 Activity와 관계가 없을 때 두 사이의 연결을 끊으며
    // Fragment에 관련된 모든 자원들이 사라지게 된다.

    @Override
    public void onDetach() {
        super.onDetach();
        //activity = null;

        Log.i("LogTest_MyPage","              onDetach()");

        getActivity().finish();

        Toast.makeText (getContext(), "앱이 종료되었습니다.",Toast.LENGTH_SHORT).show();

    }


}