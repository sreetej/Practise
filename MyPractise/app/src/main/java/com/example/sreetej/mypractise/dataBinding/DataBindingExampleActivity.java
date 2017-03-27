package com.example.sreetej.mypractise.dataBinding;


import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.sreetej.mypractise.R;
import com.example.sreetej.mypractise.databinding.ActivityDataBindingExampleBinding;

public class DataBindingExampleActivity extends AppCompatActivity {

    private ActivityDataBindingExampleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(DataBindingExampleActivity.this,R.layout.activity_data_binding_example);
        DataBindUserModel user = new DataBindUserModel();
        user.setName("Sree Tej");
        binding.setUser(user);
        binding.setActivity(this);

//        setContentView(R.layout.activity_data_binding_example);
    }

    public void onButtonClick(String email){
        Log.d("sree", "Email :" +binding.getUser().getEmail());
        Log.d("sree", "Email : "+email);
        Toast.makeText(this,email,Toast.LENGTH_SHORT).show();
    }

}
