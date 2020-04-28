package com.aamir.stylishsplashwithanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.app.backup.FullBackupDataOutput;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    Animation topanim,bottomanim;

    ImageView image;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();
        image=findViewById(R.id.appicon);
        textView=findViewById(R.id.textView);

        topanim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomanim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);


        image.setAnimation(topanim);
        textView.setAnimation(bottomanim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(SplashActivity.this,MainActivity.class);
               Pair[] pairs=new Pair[2];
               pairs[0]=new Pair<View,String>(image,"logo_image");
               pairs[1]=new Pair<View,String>(textView,"logo_text");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this, pairs);
                    startActivity(intent, options.toBundle());
                    finish();
                }

            }
        },3000);
    }
}
