package com.example.sreetej.mypractise.loaderSample;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.sreetej.mypractise.R;
import com.example.sreetej.mypractise.runtimePermissionSample.RuntimePermissionSampleActivity;


public class LoadContactsUsingLoaderActivity extends AppCompatActivity {

    private FragmentManager fm;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_contacts_using_loader);

        setTitle("Contacts");
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
//            requestContatsReadPermession();
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 0);
        } else {
            loadContactsFragment();
        }

    }



    private void loadContactsFragment() {

        new Handler().post(new Runnable() {
            public void run() {
                fm = getSupportFragmentManager();
                fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.add(R.id.container, new CursorLoaderListFragment(), "CursorLoaderListFragment").commit();
            }
        });


    }

    private void requestContatsReadPermession() {

//        Toast.makeText(RuntimePermissionSampleActivity.this,"request Camera",Toast.LENGTH_LONG).show();

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS)) {
            //Show Information about why you need the permission

//            Toast.makeText(RuntimePermissionSampleActivity.this,"request if",Toast.LENGTH_LONG).show();

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Need Permission");
            builder.setMessage("This app needs permission to read Contants.");
            builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    ActivityCompat.requestPermissions(LoadContactsUsingLoaderActivity.this, new String[]{Manifest.permission.READ_CONTACTS}, 0);

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
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 0);
        }


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        Toast.makeText(this, "in callback", Toast.LENGTH_SHORT).show();
        if (grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            loadContactsFragment();
        } else {

            finish();
        }
    }

}
