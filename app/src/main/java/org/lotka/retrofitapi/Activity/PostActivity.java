package org.lotka.retrofitapi.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.lotka.retrofitapi.Interfaces.RetrofitInterface;
import org.lotka.retrofitapi.Module.PostModule;
import org.lotka.retrofitapi.R;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class PostActivity extends AppCompatActivity {
    private static final String TAG = "mtag";
    Button submit ;
    EditText username ,password , fullname , email ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("post Activity");
        init();
        click();
    }

    private void click() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String Susername = username.getText().toString().trim();
                String Spassword = password.getText().toString().trim();
                String sfullname = fullname.getText().toString().trim();
                String Semail = email.getText().toString().trim();

                Gson gson = new GsonBuilder()
                        .setLenient()
                        .create();


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://server43.lotka.org/")
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();

               //PostModule postModule = new PostModule(Susername, Spassword, Semail ,sfullname );
                PostModule postModule = new PostModule("fthfhtfth", "hgjgjgjgyj", "gjgjgj" ,"hjkgfjfj" );

                RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);



                Call<String> mcall = retrofitInterface.postData(postModule);

                mcall.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {

                        Log.d(TAG, "onResponse: "+ response.body());

                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.d(TAG, "onFailure: "+ t.toString());
                    }
                });



            }
        });
    }

    private void init() {
        submit=findViewById(R.id.post_submit);
        username=findViewById(R.id.post_username);
        password=findViewById(R.id.post_password);
        fullname=findViewById(R.id.post_fullname);
        email=findViewById(R.id.post_email);
    }

    @Override
    public void onBackPressed() {
        startActivity( new Intent(PostActivity.this  , MainActivity.class));
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}