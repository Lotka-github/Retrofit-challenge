package org.lotka.retrofitapi.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import org.lotka.retrofitapi.Adapters.RecyclerViewAdapter;
import org.lotka.retrofitapi.Interfaces.RetrofitInterface;
import org.lotka.retrofitapi.Module.StandardJsonModule;
import org.lotka.retrofitapi.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StandardJsonActivity extends AppCompatActivity {

    private static final String TAG = "mtag";
    List<StandardJsonModule> moduleList ;
    RecyclerViewAdapter recyclerViewAdapter;
    StandardJsonActivity standardJsonActivity;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_list);
        ActionBar actionBar =getSupportActionBar();
        actionBar.setTitle("List<> activity");
        init();
        oncreate();
    }

    private void init() {
        moduleList=new ArrayList<>();
        standardJsonActivity =this ;
    }

    private void oncreate() {
        //first add the dependencies

        //create module class

        //init the Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://s1.cdin.ir/dir/json/json_examples/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //instance of module class related to retrofit
        RetrofitInterface ri = retrofit.create(RetrofitInterface.class);
        Call<List<StandardJsonModule>> mcall = ri.getFlowers();
        mcall.enqueue(new Callback<List<StandardJsonModule>>() {
            @Override
            public void onResponse(Call<List<StandardJsonModule>> call, Response<List<StandardJsonModule>> response) {
                Log.d(TAG, "onResponse: " + response.body().size());
                Log.d(TAG, "onResponse: " + response.body());
                moduleList=response.body();
                Log.d(TAG, "onResponse:  "+moduleList.size());
                if(response.body().size()>0){
                    recyclerViewAdapter = new RecyclerViewAdapter(moduleList , standardJsonActivity);
                    RecyclerView rcv =findViewById(R.id.rcv);
                    rcv.setLayoutManager(new LinearLayoutManager(standardJsonActivity));
                    rcv.setAdapter(recyclerViewAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<StandardJsonModule>> call, Throwable throwable) {
                Log.d(TAG, "onFailure: "+ throwable.getMessage().toString());
            }
        });




    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(StandardJsonActivity.this , MainActivity.class));
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}