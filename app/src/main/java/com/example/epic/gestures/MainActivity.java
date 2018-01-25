package com.example.epic.gestures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView; //to address the text
import android.widget.*;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, // for scrolling/flinging
        GestureDetector.OnDoubleTapListener{ //for double taps

    private TextView epicMessage;
    private GestureDetectorCompat gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        epicMessage = (TextView)findViewById(R.id.epic_text);
        this.gestureDetector = new GestureDetectorCompat(this, this);
        gestureDetector.setOnDoubleTapListener(this);//allow us to detect double taps as well
    }

    ///////////////// Begin Gestures ///////////////////////
    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        epicMessage.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        epicMessage.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        epicMessage.setText("onDoubleTapEventConfirmed");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        epicMessage.setText("onDownConfirmed");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        epicMessage.setText("onShowPressConfirmed");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        epicMessage.setText("onSingleTapUpConfirmed");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        epicMessage.setText("onScrollConfirmed");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        epicMessage.setText("onLongPressConfirmed");

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        epicMessage.setText("onFlingConfirmed");
        return true;
    }

    //////////////////////// End Gestures //////////////////////////


    @Override
    public boolean onTouchEvent(MotionEvent event) { //default functionality called when the screen is touched
                                                    //we want it to check if the touch was a gesture first
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
