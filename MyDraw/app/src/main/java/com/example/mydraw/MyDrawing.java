package com.example.mydraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MyDrawing extends View implements View.OnTouchListener
{
    private Paint pDraw;
    private float touchX = 0.0f, touchY = 0.0f;
    private ArrayList<Pixel> pixels;

    // Constructor for creating the View in code.
    public MyDrawing(Context context)
    {
        super(context, null);
        init(context);
    }

    // Constructor called when inflating the View from XML.
    public MyDrawing(Context context, AttributeSet attrs)
    {
        super(context, attrs, 0);
        init(context);
    }

    // Constructor called when inflating the View from XML when it has a Style
    // attribute.
    public MyDrawing(Context context, AttributeSet attrs, int defStyleattr)
    {
        super(context, attrs, defStyleattr);
        init(context);
    }
    private void init(Context context)
    {
        pDraw = new Paint();
        pDraw.setColor(Color.BLUE);
        pDraw.setStrokeWidth(5.0f);
        pDraw.setStyle(Paint.Style.FILL_AND_STROKE);
        pDraw.setAlpha(120);
        pDraw.setAntiAlias(true);
        setOnTouchListener(this);
        pixels = new ArrayList<Pixel>();
    }

    // Method callable from the Activity that contains this myDrawing view
    // that sets the color to be drawn.
    public void setColor(int color)
    {
        pDraw.setColor(color);
    }

    // Method callable from the Activity that contains this myDrawing view
    // that sets the width of the line to be drawn.
    public void setWidth(float width)
    {
        pDraw.setStrokeWidth(width);
    }

    @Override
    public void onDraw(Canvas canvas)
    {
//    float centerX = this.getWidth()/2.0f;
//    float centerY = this.getHeight()/2.0f;
//    canvas.drawCircle(touchX, touchY, 120, pDraw);
        Pixel pixel;
        if (pixels.size() == 1)
        {
            pixel = pixels.get(0);
            canvas.drawPoint(pixel.x, pixel.y, pixel.color);
        }
        else
        {
            for (int ix = 1; ix < pixels.size(); ix++)
            {
                pixel = pixels.get(ix);
                Pixel pixelPrev = pixels.get(ix-1);
                canvas.drawLine(pixelPrev.x, pixelPrev.y, pixel.x, pixel.y, pixel.color);
            }
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent)
    {
        touchX = motionEvent.getX();
        touchY = motionEvent.getY();
        Pixel pixel = new Pixel();
        pixel.x = touchX;
        pixel.y = touchY;
        pixel.color = pDraw;
        pixels.add(pixel);
        invalidate();
        return true;
    }
}
