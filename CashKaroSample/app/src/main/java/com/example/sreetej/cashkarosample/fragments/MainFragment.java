package com.example.sreetej.cashkarosample.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sreetej.cashkarosample.MainActivity;
import com.example.sreetej.cashkarosample.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {


    CarouselView carouselView;
    MainFragmentInterface mainFragmentInterfaceCallback;
    private Button code1_btn, code2_btn, code3_btn, code4_btn, goToSite_btn;

    int[] sampleImages = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4};

    @Override
    public void onClick(View view) {
        mainFragmentInterfaceCallback.changeFragment(0);
    }

    public interface MainFragmentInterface{
        public void changeFragment(int position);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        carouselView = (CarouselView) view.findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);
        carouselView.setImageClickListener(imageClickListener);

        code1_btn = (Button) view.findViewById(R.id.getcode_btn1);
        code2_btn = (Button) view.findViewById(R.id.getcode_btn2);
        code3_btn = (Button) view.findViewById(R.id.getcode_btn3);
        code4_btn = (Button) view.findViewById(R.id.getcode_btn4);


        code1_btn.setOnClickListener(this);
        code2_btn.setOnClickListener(this);
        code3_btn.setOnClickListener(this);
        code4_btn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mainFragmentInterfaceCallback = (MainFragmentInterface) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    ImageClickListener imageClickListener = new ImageClickListener() {
        @Override
        public void onClick(int position) {

            mainFragmentInterfaceCallback.changeFragment(position);
        }
    };

    @Override
    public void onDetach() {
        super.onDetach();
        mainFragmentInterfaceCallback = null;
    }

}
