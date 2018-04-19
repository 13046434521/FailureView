package com.t.failuredemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jtl.failureview.FailureView;

public class MainActivity extends AppCompatActivity {
    private FailureView failureView;

    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        failureView=findViewById(R.id.failureview);
        handler=new Handler();


        failureView.setOnClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                failureView.setLoadingShowing(true);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        failureView.setLoadingShowing(false);
                    }
                },5000);
            }
        });
    }
}
