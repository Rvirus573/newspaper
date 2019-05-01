package com.example.rezaul.newspaper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progress=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);


        progressBar = findViewById(R.id.loding_id);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                DoWork();
                startApps();
            }
        });

            thread.start();
    }


    void DoWork()
    {

        for (progress=2;progress<=100;progress=progress+2)



        try {
            Thread.sleep(30);
            progressBar.setProgress(progress);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    void startApps()
    {
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();

    }


}
