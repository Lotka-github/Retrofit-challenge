package org.lotka.retrofitapi.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.lotka.retrofitapi.R;

public class MainActivity extends AppCompatActivity {

    Button simple , list ,nested , post1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            init();
            click();



    }

    private void click() {
        simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this , StandardJsonActivity.class));
            }
        });
        nested.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this , NestedJsonActivity.class));
            }
        });
        post1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this , PostActivity.class ));
            }
        });

    }

    private void init() {
        simple=findViewById(R.id.simplejson);
        list=findViewById(R.id.listJson);
        nested=findViewById(R.id.nestedJSon);
        post1=findViewById(R.id.post1);
    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}
