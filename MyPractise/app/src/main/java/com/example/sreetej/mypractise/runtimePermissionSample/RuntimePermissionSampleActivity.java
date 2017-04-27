package com.example.sreetej.mypractise.runtimePermissionSample;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sreetej.mypractise.R;

public class RuntimePermissionSampleActivity extends AppCompatActivity {

    private Button cameraAccessBtn;
    private static final int REQUEST_CAMERA = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runtime_permission_sample);


        setTitle("RunTime Permission");

        cameraAccessBtn = (Button) findViewById(R.id.CameraPermission);

        cameraAccessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(RuntimePermissionSampleActivity.this,"onClick listener",Toast.LENGTH_LONG).show();

                if (ActivityCompat.checkSelfPermission(RuntimePermissionSampleActivity.this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(RuntimePermissionSampleActivity.this,"onClick if",Toast.LENGTH_LONG).show();
                    requestCameraPermission();

                } else {
//                    Toast.makeText(RuntimePermissionSampleActivity.this,"onClick else",Toast.LENGTH_LONG).show();
                    Log.i("RuntimePermissionSample",
                            "CAMERA permission has already been granted. Displaying camera preview.");

                }

            }
        });
    }

    private void requestCameraPermission() {

//        Toast.makeText(RuntimePermissionSampleActivity.this,"request Camera",Toast.LENGTH_LONG).show();

        Log.i("RuntimePermissionSample", "CAMERA permission has NOT been granted. Requesting permission.");
        // BEGIN_INCLUDE(camera_permission_request)

        if (ActivityCompat.shouldShowRequestPermissionRationale(RuntimePermissionSampleActivity.this, Manifest.permission.CAMERA)) {
            //Show Information about why you need the permission

//            Toast.makeText(RuntimePermissionSampleActivity.this,"request if",Toast.LENGTH_LONG).show();

            AlertDialog.Builder builder = new AlertDialog.Builder(RuntimePermissionSampleActivity.this);
            builder.setTitle("Need Storage Permission");
            builder.setMessage("This app needs storage permission.");
            builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    ActivityCompat.requestPermissions(RuntimePermissionSampleActivity.this, new String[]{Manifest.permission.CAMERA}, 0);
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();

        } else {
            //just request the permission
//            Toast.makeText(RuntimePermissionSampleActivity.this,"request else",Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(RuntimePermissionSampleActivity.this, new String[]{Manifest.permission.CAMERA}, 0);
        }


    }

}
