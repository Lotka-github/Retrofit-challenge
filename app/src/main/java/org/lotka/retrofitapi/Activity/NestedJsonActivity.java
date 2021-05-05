package org.lotka.retrofitapi.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.lotka.retrofitapi.Adapters.RecyclerViewAdapter;
import org.lotka.retrofitapi.Interfaces.RetrofitInterface;
import org.lotka.retrofitapi.Module.NestedDataModule;
import org.lotka.retrofitapi.Module.StandardJsonModule;
import org.lotka.retrofitapi.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NestedJsonActivity extends AppCompatActivity {
    private static final String TAG = "mtag";
    NestedJsonActivity nestedJsonActivity ;
    public final String URL = "https://s1.cdin.ir/dir/json/json_examples/";
    List<StandardJsonModule> mlist ;
    RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_json);
        init();
        Retrofit();
    }

    private void Retrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        RetrofitInterface ri = retrofit.create(RetrofitInterface.class);

        Call<NestedDataModule> mcall = ri.getFlowersNested();
        mcall.enqueue(new Callback<NestedDataModule>() {
            @Override
            public void onResponse(Call<NestedDataModule> call, Response<NestedDataModule> response) {
                NestedDataModule nestedDataModule = response.body();
                mlist=new ArrayList<>(Arrays.asList(nestedDataModule.getStandardJsonModuleNestedModule()));
                showInRcv(mlist);

            }

            @Override
            public void onFailure(Call<NestedDataModule> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });


    }

    private void showInRcv(List<StandardJsonModule> mlist) {
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter( mlist,nestedJsonActivity);
        recyclerView.setLayoutManager(new LinearLayoutManager(nestedJsonActivity));
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void init() {
        nestedJsonActivity=this;
        recyclerView = findViewById(R.id.nested_rcv);

    }
}