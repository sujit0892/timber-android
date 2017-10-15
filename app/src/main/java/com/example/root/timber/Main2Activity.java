package com.example.root.timber;

import android.app.Activity;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;

public class Main2Activity extends Activity {
    TimberView timberView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        timberView= new TimberView(this,size.x,size.y);
        setContentView(timberView);
    }

    @Override
    public void onResume(){
        super.onResume();
        timberView.resume();

    }

    @Override
    public void onPause(){
        super.onPause();
        timberView.pause();
    }
}
