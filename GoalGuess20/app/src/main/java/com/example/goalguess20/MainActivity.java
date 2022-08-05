package com.example.goalguess20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_mv, btngls, login;
    EditText et_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_mv = findViewById(R.id.button2);
        btn_mv.setOnClickListener(new MKTClick());
        btngls = findViewById(R.id.button);
        btngls.setOnClickListener(new GoalsClick());
        et_password = findViewById(R.id.et_password);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_password.getText().toString().equals("Admin")) {
                    Intent intent = new Intent(getApplicationContext(), CustomerModel.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private class MKTClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), MarketVal.class);
            startActivity(intent);
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