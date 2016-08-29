package com.example.shacan.customprogressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shacan.customprogressbar.widget.ProgressView;

public class MainActivity extends AppCompatActivity {
//    private ProgressView progressView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        progressView = (ProgressView) findViewById(R.id.progressView);

//        new Thread() {
//            @Override
//            public void run() {
//                for (int i =1;i<=100;i++){
//                    progressView.setMyProgress(i);
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }
//        }.start();
    }
}
