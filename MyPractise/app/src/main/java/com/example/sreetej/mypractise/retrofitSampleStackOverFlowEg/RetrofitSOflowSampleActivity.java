package com.example.sreetej.mypractise.retrofitSampleStackOverFlowEg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.sreetej.mypractise.R;
import com.example.sreetej.mypractise.retrofitSampleStackOverFlowEg.data.remote.SOService;
import com.example.sreetej.mypractise.retrofitSampleStackOverFlowEg.model.Item;
import com.example.sreetej.mypractise.retrofitSampleStackOverFlowEg.model.SOAnswerResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitSOflowSampleActivity extends AppCompatActivity {

    private AnswersAdapter adapter;
    private RecyclerView recyclerView;
    private SOService mService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_soflow_sample);

        setTitle("Stack Over Flow Answers");

        recyclerView = (RecyclerView) findViewById(R.id.activity_recycler_view);
        mService = ApiUtils.getSOService();

        adapter = new AnswersAdapter(this, new ArrayList<Item>(0), new AnswersAdapter.PostItemListener() {
            @Override
            public void onPostClick(long id) {
                Toast.makeText(RetrofitSOflowSampleActivity.this, "Post id is" + id, Toast.LENGTH_SHORT).show();
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        loadAnswers();
    }

    private void loadAnswers() {
        mService.getAnswers().enqueue(new Callback<SOAnswerResponse>() {
            @Override
            public void onResponse(Call<SOAnswerResponse> call, Response<SOAnswerResponse> response) {
                    if (response.isSuccessful()){
                        adapter.updateAnswers(response.body().getItems());
                        Log.d("MainActivity", "posts loaded from API");
                    }else {
                        int statusCode = response.code();
                    }
            }

            @Override
            public void onFailure(Call<SOAnswerResponse> call, Throwable t) {
                Log.d("MainActivity", "error loading from API");
            }
        });
    }

}
