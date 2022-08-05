package com.example.realgudproject1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity
{
    EditText et;
    Button btnSave;
    Button btnShowList;
    boolean fragNull = true;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        et = findViewById(R.id.editTextTextPersonName);
        btnSave = findViewById(R.id.btnSave);
        btnShowList = findViewById(R.id.button2);
        btnSave.setOnClickListener(new SaveClick(this));
        btnShowList.setBackgroundColor(Color.RED);
        btnShowList.setOnClickListener(new SaveClick(this));
        Intent intent = getIntent();
        if (intent != null)
        {
            String str = intent.getStringExtra("Name");
            et.setText(str);
        }
        setFragEnter();
    }

    public void setFragEnter()
    {
        if (!fragNull)
        {
/*      FragmentManager fragmentManager = getSupportFragmentManager();
      // Check to see if the fragment is already showing.
      fragmentShow fragshow = (fragmentShow) fragmentManager.findFragmentById(R.id.fragFrame);
      FragmentTransaction fragmentTransaction =
              fragmentManager.beginTransaction();
      fragmentTransaction.remove(fragshow).commit();
 */
        }
        FragmentEnter fragEnter = FragmentEnter.newInstance(" "," ");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.FragFrame, fragEnter).addToBackStack(null).commit();
        fragNull = false;
    }


    private class SaveClick implements View.OnClickListener
    {
        MainActivity2 parent;
        public SaveClick(MainActivity2 p)
        {
            parent = p;
        }
        @Override
        public void onClick(View view)
        {
            if (view.getId()== R.id.btnSave)
            {
                Intent intent = new Intent();
                String str = et.getText().toString();
                intent.putExtra("Name", str);
                setResult(1, intent);
                finish();
            }
            if (view.getId() == R.id.button2)
            {
                Intent intent = new Intent(getApplicationContext(), LActivity.class);
                parent.startActivity(intent);
            }
        }
    }
}