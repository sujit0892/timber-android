package com.example.root.timber;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by root on 10/12/17.
 */

public class TimberView extends SurfaceView implements  Runnable{
    boolean playing = true;
    private Canvas canvas;
    Bitmap tree,background;
    SurfaceHolder ourHolder;
    Context context;
    private Paint paint;
    Thread thread =null;
    bee bee;
    branch branch1,branch2,branch3,branch4;
    int X,Y;
    Cloud cloud1,cloud2,cloud3;
    int Y1,Y2,Y3,Y4;
    boolean gameEnded=false;boolean startgame = false;
    public TimberView(Context context, int x, int y) {
        super(context);
        this.context =context;
        X=x;
        Y=y;
        paint = new Paint();
        paint.setColor(Color.argb(255,255,255,255));
        ourHolder = getHolder();
        startGame();


    }

    @Override
    public void run() {
        while (playing) {
            draw();
            if(!gameEnded) {
                update();
            }

            control();
        }

    }

    private void control() {
    }

    private void update() {

        cloud1.update();
        cloud2.update();
        cloud3.update();
        bee.update();
        branch1.update();
        branch2.update();
        branch3.update();
        branch4.update();

        if(branch1.getY()==Y-Y/3&&bee.getPosition()==branch1.getPosition()%2){

            gameEnded = true;
        }
        Log.e("bee", String.valueOf(bee.getPosition()));
        Log.e("branch", String.valueOf(branch2.getPosition()%2));
        if(branch2.getY()==Y-Y/3 && bee.getPosition()==branch2.getPosition()%2)
        {   Log.e("msg","break");
            gameEnded=true;
        }
        if(branch3.getY()==Y-Y/3&&bee.getPosition()==branch3.getPosition()%2){
            gameEnded = true;
        }
        if(branch4.getY()==Y-Y/3&&bee.getPosition()==branch4.getPosition()%2){
            gameEnded = true;
        }

    }

    public void resume(){

        playing = true;
        thread =new Thread(this);
        thread.start();
    }

    public void pause(){
        playing = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void draw(){

        if(ourHolder.getSurface().isValid()){

            canvas = ourHolder.lockCanvas();

            canvas.drawColor(Color.argb(255, 255, 255, 255));
            canvas.drawBitmap(bee.getBackground(), 0, 0, paint);
            canvas.drawBitmap(cloud1.getCloud(), cloud1.getX(), cloud1.getY(), paint);
            canvas.drawBitmap(cloud2.getCloud(), cloud2.getX(), cloud2.getY(), paint);
            canvas.drawBitmap(cloud3.getCloud(), cloud3.getX(), cloud3.getY(), paint);
            canvas.drawBitmap(bee.getTree(), X / 2, 0, paint);
            canvas.drawBitmap(branch1.getBranch(), branch1.getX(), branch1.getY(), paint);
            canvas.drawBitmap(branch2.getBranch(), branch2.getX(), branch2.getY(), paint);
            canvas.drawBitmap(branch3.getBranch(), branch3.getX(), branch3.getY(), paint);
            canvas.drawBitmap(branch4.getBranch(), branch4.getX(), branch4.getY(), paint);
            canvas.drawBitmap(bee.getPlayer(), bee.getPlayerX(), Y - Y / 3, paint);
            canvas.drawBitmap(bee.getBee(), bee.getX(), Y - Y / 3, paint);


            if(gameEnded)
            {   paint.setTextSize(80);
                paint.setTextAlign(Paint.Align.CENTER);
                canvas.drawText("Start", X/2, 100, paint);
                canvas.drawText("Tap to play!", X/2, 350, paint);
            }
            ourHolder.unlockCanvasAndPost(canvas);




        }


    }
    public void startGame(){

        bee= new bee(context,X,Y);
        cloud1=new Cloud(context,X,Y);
        cloud2=new Cloud(context,X,Y);
        cloud3=new Cloud(context,X,Y);
        Y1 = bee.getTree().getHeight()/4;
        Y2 = 3*bee.getTree().getHeight()/4;
        Y3 = bee.getTree().getHeight()/2;
        Y4 = bee.getTree().getHeight();
        branch1=new branch(context,X,Y,Y1);
        branch2=new branch(context,X,Y,Y2);
        branch3=new branch(context,X,Y,Y3);
        branch4=new branch(context,X,Y,Y4);
        gameEnded=false;

    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        int x= (int) motionEvent.getX();
        if(x<X/2)
        {
            bee.setPlayerX(X/2-bee.getPlayer().getWidth());
            bee.setPosition(0);
        }
        else
        {
            bee.setPlayerX(X/2+bee.getTree().getWidth());
            bee.setPosition(1);
        }
        if(gameEnded){
            startGame();
        }
        return true;
    }
}
