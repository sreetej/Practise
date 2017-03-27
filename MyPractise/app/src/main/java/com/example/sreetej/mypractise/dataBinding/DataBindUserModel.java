package com.example.sreetej.mypractise.dataBinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.sreetej.mypractise.BR;

/**
 * Created by sreetej on 27/03/17.
 */

public class DataBindUserModel extends BaseObservable {
    private String name; private String email;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }




}
