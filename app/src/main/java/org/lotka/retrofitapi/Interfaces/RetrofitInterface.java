package org.lotka.retrofitapi.Interfaces;

import androidx.annotation.RawRes;

import org.lotka.retrofitapi.Module.NestedDataModule;
import org.lotka.retrofitapi.Module.StandardJsonModule;
import org.lotka.retrofitapi.Module.PostModule;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitInterface {

//    http://server43.lotka.org/signup.php

    @GET ("flowers.json")
    Call <List<StandardJsonModule>> getFlowers();

    @GET ("flowersinnested.json")
    Call <NestedDataModule> getFlowersNested();

    @POST ("signup.php")
    Call <String> postData(@Body PostModule postModule);

}
