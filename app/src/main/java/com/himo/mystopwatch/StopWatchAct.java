package com.himo.mystopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

public class StopWatchAct extends AppCompatActivity {

    Button btnstart, btnstop;
    ImageView arrow;
    Animation roundinglone;
    Chronometer timer;
    TextView never;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnstart = findViewById(R.id.btnstart);
        arrow =findViewById(R.id.arrow);
        btnstop = findViewById(R.id.btnstop);
        timer =findViewById(R.id.timer);
        never = findViewById(R.id.never);

        btnstop.setAlpha(0);
        never.setAlpha(0);


        roundinglone = AnimationUtils .loadAnimation(this, R.anim.roundinglone);

        btnstart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                arrow.startAnimation(roundinglone);
                btnstop.animate().alpha(1).translationY(-150).setDuration(300).start();
                btnstart.animate().alpha(0).setDuration(300).start();

                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();
            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                never.animate().alpha(1).setDuration(300).start();



            }
        });
    }
}