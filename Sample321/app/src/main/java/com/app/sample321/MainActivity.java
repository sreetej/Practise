package com.app.sample321;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nextPageButton = (Button) findViewById(R.id.btn_next);
        nextPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });

        ImageButton imageButton = (ImageButton) findViewById(R.id.imageBtn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });


        Button nextPageButton2 = (Button) findViewById(R.id.btn_next2);
        nextPageButton2.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {

                Intent intent =  new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent);
            }
        });


    }
}
