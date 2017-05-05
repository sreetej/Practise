package com.example.sreetej.mypractise.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.sreetej.mypractise.R;
import com.example.sreetej.mypractise.adapter.CustomRecyclerViewAdapter;
import com.example.sreetej.mypractise.compoundViewSample.CompoundViewActivity;
import com.example.sreetej.mypractise.dataBindingSample.DataBindingExampleActivity;
import com.example.sreetej.mypractise.dialogsInFragmentExample.DiagInFragActicity;
import com.example.sreetej.mypractise.retrofitSample.RectrofitSampleActivity;
import com.example.sreetej.mypractise.runtimePermissionSample.RuntimePermissionSampleActivity;
import com.example.sreetej.mypractise.util.RecyclerItemClickListener;

public class RecyclerViewActivity extends AppCompatActivity implements RecyclerItemClickListener.OnItemClickListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mRecAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private String[] dataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        dataSet = new String[]{"Data Binding", "Compound View", "Runtime Permission Sample", "Dialogs with Fragments", "Rectofit Sample"};


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        mRecAdapter = new CustomRecyclerViewAdapter(dataSet);
        mRecyclerView.setAdapter(mRecAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, this));


    }


    @Override
    public void onItemClick(View childView, int position) {
        Toast.makeText(RecyclerViewActivity.this, "position:" + dataSet[position], Toast.LENGTH_LONG).show();
        switch (position) {
            case 0 :
                dataBinding();
                break;

            case 1 :
                startActivity(new Intent(RecyclerViewActivity.this, CompoundViewActivity.class));
                break;

            case 2 :
                startActivity(new Intent(RecyclerViewActivity.this, RuntimePermissionSampleActivity.class));
                break;

            case 3 :
                startActivity(new Intent(RecyclerViewActivity.this, DiagInFragActicity.class));
                break;
            case 4 :
                startActivity(new Intent(RecyclerViewActivity.this, RectrofitSampleActivity.class));
                break;

            default:
                Toast.makeText(RecyclerViewActivity.this,"Select right choice", Toast.LENGTH_SHORT).show();
        }
    }

    private void dataBinding() {
        startActivity(new Intent(RecyclerViewActivity.this, DataBindingExampleActivity.class));
    }

    @Override
    public void onItemLongPress(View childView, int position) {
        Toast.makeText(RecyclerViewActivity.this, "" + dataSet[position], Toast.LENGTH_LONG).show();

    }
}
