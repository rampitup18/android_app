package com.example.mydraw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    private MyDrawing myDrawing;
    private Button btnRed;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDrawing = findViewById(R.id.myDrawing);
        btnRed = findViewById(R.id.btnRed);
        btnRed.setOnClickListener(new ButtonListener());
        btnRed.setTag(new Integer(0xffff));
    }

    private class ButtonListener implements View.OnClickListener
    {

        @Override
        public void onClick(View view)
        {
            myDrawing.setColor(((Integer)((Button)view).getTag()));
        }
    }
}