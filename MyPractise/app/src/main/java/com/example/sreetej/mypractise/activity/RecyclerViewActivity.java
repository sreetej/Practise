package com.example.sreetej.mypractise.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.sreetej.mypractise.R;
import com.example.sreetej.mypractise.adapter.CustomRecyclerViewAdapter;
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

        dataSet = new String[]{"A", "B"};


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
    }

    @Override
    public void onItemLongPress(View childView, int position) {
        Toast.makeText(RecyclerViewActivity.this, "long press:" + position, Toast.LENGTH_LONG).show();

    }
}
