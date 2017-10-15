package com.example.root.timber;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

/**
 * Created by root on 10/15/17.
 */

public class LogAxe {
    Bitmap axe, log;
    int speed = 150,X,Y,maxX;
    bee tree;
    int position;

    public LogAxe(Context context, int x, int y) {
        log = BitmapFactory.decodeResource(context.getResources(), R.drawable.log);
        log = Bitmap.createScaledBitmap(log, log.getWidth() / 4, log.getHeight() / 3, false);
        tree = new bee(context, x, y);
        X=x/2;
        Y=y-y/3;
        maxX=x;
        position=0;

    }

    public void update() {

        if(position==1){

            if(X<maxX/4){
                X=maxX/2;
            }
            X-=speed;
        }
        else
        {

            if(X>3*maxX/4){
                X=maxX/2;
            }
            X+=speed;
        }
    }

    public int getX(){
        return X;
    }
    public int getY(){
        return Y;
    }


    public void setPosition(int pos){
         position=pos;
    }




    public Bitmap getLog(){
        return log;
    }
}
