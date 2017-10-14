package com.example.root.timber;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.util.Log;

import java.util.Random;

import static com.example.root.timber.R.drawable.log;

/**
 * Created by root on 10/14/17.
 */

public class branch {
    Bitmap branch_left,branch_right;
    int X_LEFT;
    int X_RIGHT;
    int position;
    int X,Y,maxY;
    Matrix matrix;
    Random generator;

    int speed = 6;
    Context context;
    public branch(Context context,int x,int y,int Y) {
        branch_left = BitmapFactory.decodeResource(context.getResources(), R.drawable.branch1);
        branch_left = Bitmap.createScaledBitmap(branch_left, branch_left.getWidth() / 4, branch_left.getHeight() / 4, false);
        branch_right = BitmapFactory.decodeResource(context.getResources(), R.drawable.branch2);
        branch_right = Bitmap.createScaledBitmap(branch_right, branch_right.getWidth() / 4, branch_right.getHeight() / 4, false);
        bee tree = new bee(context, x, y);

        X_LEFT = x / 2 - branch_right.getWidth();
        X_RIGHT = x / 2 + tree.getTree().getWidth();
        generator = new Random();
        X=X_LEFT;
        this.Y=Y;
        maxY = y - y/3+tree.getPlayer().getHeight();
        this.context=context;
        position=0;

    }

    public void setX(){
        position=generator.nextInt(30);
        if(position%2==1){
            X=X_RIGHT;


        }
        else
            X=X_LEFT;


    }

    public Bitmap getBranch(){
        if(position%2==1)
        return branch_right;
        else
            return branch_left;
    }

    public int getX(){
        return X;
    }

    public int getY(){
        return Y;
    }



    public void update(){
        Y+=speed;
        if(Y>maxY){
            Y=0;

            setX();

        }
    }

    public int getPosition(){
        return position;
    }

}
