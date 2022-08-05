package com.example.goalguess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_mv, btngls;
    private Database_Helper database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = new Database_Helper(getApplicationContext());
        btn_mv = findViewById(R.id.button2);
        btn_mv.setOnClickListener(new MKTClick());
        btngls = findViewById(R.id.button3);
        btngls.setOnClickListener(new GoalsClick());
    }
    private class MKTClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), MarketVal.class);
        startActivity(intent);
            int row = database.getRowCount();
            Toast toast=Toast. makeText(getApplicationContext(),"Rowcount" + row,Toast. LENGTH_SHORT);

            toast.show();
        }
    }
    private class GoalsClick implements  View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), Goals.class);
            startActivity(intent);
        }
    }
}