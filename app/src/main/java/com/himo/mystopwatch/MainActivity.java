package com.himo.mystopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnget;
    Animation alpha, btgone, btnanim;
    ImageView vector;
    TextView tvText, tvSubText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvText = findViewById(R.id.tvText);
        tvSubText = findViewById(R.id.tvSubText);
        btnget = findViewById(R.id.btnget);
        vector = findViewById(R.id.vector);

        alpha = AnimationUtils .loadAnimation(this,R.anim.alpha);
        btgone = AnimationUtils .loadAnimation(this,R.anim.btgone);
        btnanim = AnimationUtils .loadAnimation(this,R.anim.btnanim);

        vector.startAnimation(alpha);
        tvText.startAnimation(btgone);
        tvSubText.startAnimation(btgone);
        btnget.startAnimation(btnanim);

        btnget.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, StopWatchAct.class);
                a.addFlags((Intent.FLAG_ACTIVITY_NO_ANIMATION));
                startActivity(a);
            }
        });
    }
}