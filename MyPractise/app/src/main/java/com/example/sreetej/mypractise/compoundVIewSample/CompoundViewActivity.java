package com.example.sreetej.mypractise.compoundViewSample;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.example.sreetej.mypractise.R;

public class CompoundViewActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compound_view);

        SideSpinner fruitsSpinner;
        fruitsSpinner = (SideSpinner)this
                .findViewById(R.id.sidespinner_fruits);

        CharSequence fruitList[] = { "Apple",
                "Orange",
                "Pear",
                "Grapes" };
        fruitsSpinner.setValues(fruitList);
        fruitsSpinner.setSelectedIndex(1);

    }


}
