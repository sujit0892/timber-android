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
    int speed = 150,X,Y,maxX,axeX;
    bee tree;
    int position;
    Thread thread;

    public LogAxe(Context context, int x, int y) {
        log = BitmapFactory.decodeResource(context.getResources(), R.drawable.log);
        log = Bitmap.createScaledBitmap(log, log.getWidth() / 4, log.getHeight() / 3, false);

        axe =BitmapFactory.decodeResource(context.getResources(),R.drawable.axe);
        axe = Bitmap.createScaledBitmap(axe, axe.getWidth() / 4, axe.getHeight() / 3, false);
        tree = new bee(context, x, y);
        axeX=x/2+tree.getPlayer().getWidth()/2+tree.getTree().getWidth();
        X=x/2;
        Y=y-y/3;
        maxX=x;
        position=0;
        thread= new Thread();


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

    public void updateAxe(){

        if(position==1) {
            axeX=maxX/2+tree.getPlayer().getWidth()/2+tree.getTree().getWidth();
            axeX -= getAxe().getWidth();

            try {
                thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            axeX += getAxe().getWidth();
        }
        else
        {
            axeX=maxX/2-2*axe.getWidth();
            axeX += getAxe().getWidth();

            try {
                thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            axeX -= getAxe().getWidth();



        }
    }

    public int getAxeX(){
        return axeX;
    }




    public Bitmap getLog(){
        return log;
    }
    public Bitmap getAxe(){
        return axe;
    }


}
