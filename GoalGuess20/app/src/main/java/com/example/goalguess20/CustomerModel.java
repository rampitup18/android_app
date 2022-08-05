package com.example.goalguess20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class CustomerModel extends AppCompatActivity {
    Button btn_add, btn_viewall;
    EditText et_gls, et_mv, et_name;
    ListView lvplayerlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_model);
        btn_add = findViewById(R.id.Add);
        btn_viewall = findViewById(R.id.view);
        et_gls = findViewById(R.id.et_gls);
        et_mv = findViewById(R.id.et_mv);
        et_name = findViewById(R.id.editTextTextPersonName);
        lvplayerlist = findViewById(R.id.lvplayerlist);
        btn_add.setOnClickListener(new addClick());
        btn_viewall.setOnClickListener(new ViewClick());
    }
    private class addClick implements View.OnClickListener
    {
            @Override
            public void onClick(View v) {
                databaseModel databaseModel;
                try {
                    databaseModel = new databaseModel(-1, et_name.getText().toString(), Integer.parseInt(et_gls.getText().toString()), Float.parseFloat(et_mv.getText().toString()));
                    Toast.makeText(CustomerModel.this, databaseModel.toString(), Toast.LENGTH_SHORT).show();
                }catch (Exception e) {
                    Toast.makeText(CustomerModel.this, "Error Creating Player", Toast.LENGTH_SHORT).show();
                    databaseModel = new databaseModel(-1, "error", 0, 0);
                }
                Database_Helper database_helper = new Database_Helper(CustomerModel.this);
                boolean success = database_helper.addOne(databaseModel);
                Toast.makeText(CustomerModel.this, "Success = " + success, Toast.LENGTH_SHORT).show();
            }
        };
    private class ViewClick implements  View.OnClickListener{
            @Override
            public void onClick(View view) {
                Toast.makeText(CustomerModel.this, "View All Button", Toast.LENGTH_SHORT).show();
            }
        };

    }