package com.example.oddeven;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView randomtxt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        Button btn2 = findViewById(R.id.button2);
        TextView randomtxt = findViewById(R.id.textView);
    }

    public void helloClick(View view) {
    }

    private class ButtonClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Random value = new Random();
            int val = value.nextInt(1000000000);
            randomtxt.setText(Integer.toString(val));
        }
    }
}