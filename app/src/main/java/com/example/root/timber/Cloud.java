package com.example.root.timber;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

/**
 * Created by root on 10/13/17.
 */

public class Cloud {

    Bitmap cloud;
    Random random;
    int x,maxX,speed,minY,maxY,y;
    public Cloud(Context context,int x,int y){
        cloud= BitmapFactory.decodeResource(context.getResources(),R.drawable.cloud);
        cloud = Bitmap.createScaledBitmap(cloud,cloud.getWidth()/4,cloud.getHeight()/4,false);
        random = new Random();
        speed = random.nextInt(3)+1;
        maxX=x;
        maxY=y/4;
        minY=0;
        this.x=random.nextInt(maxX);
        this.y=random.nextInt(maxY);

    }


    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void update(){
        x+=speed;
        if(x>maxX){
            x=0;
            y=random.nextInt(maxY);
            speed = random.nextInt(3)+1;
        }

    }

    public Bitmap getCloud(){
        return cloud;
    }
}
