package com.example.sreetej.cashkarosample;

import android.Manifest;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.NavigationView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.sreetej.cashkarosample.fragments.ChildFragment1;
import com.example.sreetej.cashkarosample.fragments.MainFragment;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInterface, ChildFragment1.NotificationInterface{

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private Fragment fragment;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initNavigationDrawer();

        fragment = new MainFragment();

        setFragment(fragment);

    }

    private void setFragment(Fragment fragment) {

        FragmentManager fragmentTransaction = getSupportFragmentManager();
        FragmentTransaction fragmentManager = fragmentTransaction.beginTransaction();
        fragmentManager.addToBackStack(null);
        fragmentManager.replace(R.id.fragment_container,fragment);
        fragmentManager.commit();
    }

    private void initNavigationDrawer() {

        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                int id = menuItem.getItemId();

                switch (id){
                    case R.id.home:
                        setFragment(new MainFragment());
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.camera:
                        grantPermissionForCamera();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.location:
                        grantPermissionForLocation();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.logout:
                        finish();

                }
                return true;
            }
        });
        View header = navigationView.getHeaderView(0);
        TextView tv_email = (TextView)header.findViewById(R.id.tv_email);
        tv_email.setText("sree.kothamasu@gmail.com");
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close){

            @Override
            public void onDrawerClosed(View v){
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void grantPermissionForLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            Toast.makeText(getApplicationContext(),"Location Permission is already Granted",Toast.LENGTH_SHORT).show();
        }
    }

    private void grantPermissionForCamera() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        } else {
            Toast.makeText(getApplicationContext(),"Camera Permission is already Granted",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
    }

    @Override
    public void changeFragment(int position) {

        switch (position){
            case 0 :
               setFragment(new ChildFragment1());
                setTitle("Amazon");
                break;
            case 1 :
                setFragment(new ChildFragment1());
                setTitle("SnapDeal");
                break;
            case 2 :
                setFragment(new ChildFragment1());
                setTitle("Flipkart");
                break;
            case 3 :
                setFragment(new ChildFragment1());
                setTitle("Paytm");
                break;


            default:
                setFragment(new MainFragment());

        }
    }

    @Override
    public void createNotification( String message) {
        addNotification(message);
    }

    private void addNotification(String message) {
        NotificationCompat.Builder builder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_icon)
                        .setContentTitle("CashKaro")
                        .setContentText(message);

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);


        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {


        if(requestCode == 0){
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Camera Permission Granted", Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(this, "Camera Permission Denyed", Toast.LENGTH_SHORT).show();
            }
        }else if(requestCode == 1){
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Location Permission Granted", Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(this, "Location Permission Denyed", Toast.LENGTH_SHORT).show();
            }
        }


    }
}
