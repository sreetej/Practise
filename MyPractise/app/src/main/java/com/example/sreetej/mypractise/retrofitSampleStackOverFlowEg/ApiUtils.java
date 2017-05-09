package com.example.sreetej.mypractise.retrofitSampleStackOverFlowEg;

import com.example.sreetej.mypractise.retrofitSampleStackOverFlowEg.data.remote.RetrofitClient;
import com.example.sreetej.mypractise.retrofitSampleStackOverFlowEg.data.remote.SOService;

/**
 * Created by sreetej on 09/05/17.
 */

public class ApiUtils {
    public static final String BASE_URL = "https://api.stackexchange.com/2.2/";

    public static SOService getSOService(){
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}
