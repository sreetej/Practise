package com.example.sreetej.cashkarosample.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sreetej.cashkarosample.R;
import com.example.sreetej.cashkarosample.WebViewActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChildFragment1 extends Fragment implements View.OnClickListener {

    NotificationInterface mNoticationInterface;
    private Button code1_btn, code2_btn, code3_btn, code4_btn, goToSite_btn;

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.amazon_btn){

            startActivity(new Intent(getActivity(), WebViewActivity.class));

        }else{
            mNoticationInterface.createNotification("Congratulations you have clicked on Amazon");
        }

    }

    public interface NotificationInterface{
        public void createNotification(String message);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_child_fragment1, container, false);

        code1_btn = (Button) view.findViewById(R.id.getcode_btn1);
        code2_btn = (Button) view.findViewById(R.id.getcode_btn2);
        code3_btn = (Button) view.findViewById(R.id.getcode_btn3);
        code4_btn = (Button) view.findViewById(R.id.getcode_btn4);
        goToSite_btn = (Button) view.findViewById(R.id.amazon_btn);

        code1_btn.setOnClickListener(this);
        code2_btn.setOnClickListener(this);
        code3_btn.setOnClickListener(this);
        code4_btn.setOnClickListener(this);
        goToSite_btn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mNoticationInterface = (NotificationInterface) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnHeadlineSelectedListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mNoticationInterface = null;
    }
}
