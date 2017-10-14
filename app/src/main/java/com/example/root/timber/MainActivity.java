package com.example.root.timber;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button play = (Button) findViewById(R.id.play);
        play.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent(this, game.class);
        startActivity(i);
        finish();
    }
}
