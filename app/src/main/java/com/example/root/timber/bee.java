package com.example.root.timber;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

/**
 * Created by root on 10/12/17.
 */

public class bee {

    int x,speed,maxX;
    Random random;
    int PlayerX;
    int position;

    private Bitmap background,bee,tree,player,Rip,tree1;
    public bee(Context context, int x, int y){
        background= BitmapFactory.decodeResource(context.getResources(),R.drawable.background);
        background=Bitmap.createScaledBitmap(background,x,y,false);
        bee = BitmapFactory.decodeResource(context.getResources(),R.drawable.bee);
        bee=Bitmap.createScaledBitmap(bee,bee.getWidth()/4,bee.getHeight()/4,false);
        tree = BitmapFactory.decodeResource(context.getResources(),R.drawable.tree);
        tree=Bitmap.createScaledBitmap(tree,tree.getWidth()/4,tree.getHeight()/3,false);
        tree1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.tree2);
        tree1=Bitmap.createScaledBitmap(tree1,tree1.getWidth()/4,tree1.getHeight()/4,false);
        player = BitmapFactory.decodeResource(context.getResources(),R.drawable.player);
        player=Bitmap.createScaledBitmap(player,player.getWidth()/4,player.getHeight()/3,false);
        Rip = BitmapFactory.decodeResource(context.getResources(),R.drawable.rip);
        Rip=Bitmap.createScaledBitmap(Rip,Rip.getWidth()/3,Rip.getHeight()/2,false);
        random = new Random();
        this.x=random.nextInt(x);
        speed=random.nextInt(3)+1;
        maxX=x;
        PlayerX = x/2+tree.getWidth();
        position=0;
    }

    public void update(){
        x-=speed;
        if(x<0)
        {
            x=maxX;
            speed=random.nextInt(3)+1;
        }
    }

    public Bitmap getBackground(){
        return background;
    }
    public Bitmap getBee(){
        return bee;
    }
    public Bitmap getTree(){
        return tree;
    }
    public Bitmap getTree1(){
        return tree1;
    }

    public Bitmap getPlayer(){
        return player;
    }
    public int getX(){
        return x;
    }

    public int getPlayerX(){
        return PlayerX;
    }
    public void setPlayerX(int x){
        PlayerX=x;
    }

    public int getPosition(){
        return position ;
    }
    public void setPosition(int pos){
        position=pos;

    }

    public Bitmap getRip(){
        return Rip;
    }
}
