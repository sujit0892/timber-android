package com.example.root.timber;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
    TimberView timberView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        setContentView(R.layout.activity_main);
        Button play=findViewById(R.id.play);
        play.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent i = new Intent(this,Main2Activity.class);
        startActivity(i);
        finish();
    }
}
