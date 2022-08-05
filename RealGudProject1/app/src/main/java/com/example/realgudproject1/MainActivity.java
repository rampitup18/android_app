/******************************************************************************
 * Android Summer Internship sample program 1.
 *
 * Written by John Cole at The University of Texas at Dallas starting
 * June 13, 2022.
 ******************************************************************************/
package com.example.realgudproject1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView tvHello;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Set the click listeners for the text and the button.
        tvHello = findViewById(R.id.idHello);
        tvHello.setOnClickListener(new Clicker());
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new ButtonClick());
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    /****************************************************************************
     * This private inner class handles clicks on the text on the main screen.
     * Change the text color.
     ****************************************************************************/
    private class Clicker implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            TextView tv = (TextView) view;
            if (tv.getCurrentTextColor() == Color.RED)
                tv.setTextColor(Color.BLACK);
            else
                tv.setTextColor(Color.RED);
        }
    }

    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data)
    {
        super.onActivityResult(reqCode, resultCode, data);
        if (reqCode == 1)
        {
            String str = data.getStringExtra("Name");
            tvHello.setText(str);
        }
    }

    /****************************************************************************
     * This private inner class handles button clicks.  Start a new Activity
     * using an Intent.
     ****************************************************************************/
    private class ButtonClick implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
            intent.putExtra("Name", "Prof. Cole");
            startActivityForResult(intent, 1);
        }
    }

}

