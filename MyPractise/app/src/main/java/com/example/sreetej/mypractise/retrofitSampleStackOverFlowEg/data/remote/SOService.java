package com.example.sreetej.mypractise.retrofitSampleStackOverFlowEg.data.remote;

import com.example.sreetej.mypractise.retrofitSampleStackOverFlowEg.model.SOAnswerResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sreetej on 09/05/17.
 */

public interface SOService {

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<SOAnswerResponse> getAnswers();

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<SOAnswerResponse> getAnswers(@Query("tagged") String tags);
}
