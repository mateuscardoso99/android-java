package com.example.gesturedetection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GestureDetectorCompat gest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.gest = new GestureDetectorCompat(this, new GestureListener());
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Toast.makeText(MainActivity.this,"fling",Toast.LENGTH_SHORT).show();
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Toast.makeText(MainActivity.this,"double tap",Toast.LENGTH_SHORT).show();
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Toast.makeText(MainActivity.this,"single tap confirmed",Toast.LENGTH_SHORT).show();
            return super.onSingleTapConfirmed(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            Toast.makeText(MainActivity.this,"long press",Toast.LENGTH_SHORT).show();
            super.onLongPress(e);
        }
        //EXISTEM MUITOS OUTROS MÉTODOS PARA SE IMPLEMENTAR TAMBÉM
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gest.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
