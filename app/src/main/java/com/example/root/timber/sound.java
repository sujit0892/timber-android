package com.example.root.timber;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

import java.io.IOException;

/**
 * Created by root on 10/15/17.
 */

public class sound {


    MediaPlayer mp,mp1;

    public sound(Context context){
       mp = MediaPlayer.create(context.getApplicationContext(), R.raw.chop);
        mp1 = MediaPlayer.create(context.getApplicationContext(), R.raw.out_of_time);





    }

    public void playChop(){
        mp.start(); //sp.play(soundId[0], 1, 1, 1, 0, (float) 1.0);
    }
    public void playDead(){
     mp1.start();
    }
}
