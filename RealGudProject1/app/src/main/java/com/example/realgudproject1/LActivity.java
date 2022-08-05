package com.example.realgudproject1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.*;

public class LActivity extends AppCompatActivity
{
    RecyclerView list;
    String[] listData;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lactivity);
        list = findViewById(R.id.list1);
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new SaveListener());
        listData = new String[4];
        listData[0] = "John\tCole\t1234";
        listData[1] = "Jey\tVeerasamy\t2345";
        listData[2] = "Laxmi\tEpuri\t4567";
        listData[3] = "Ovidiu\tDaescu\t1111";
        try
        {
            final SimpleAdapter adapter = new SimpleAdapter(listData, this);
            list.setAdapter(adapter);
        } catch (Exception ex)
        {
            //tvMessage.setText(R.string.erroradapter);
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

    }
    private class SaveListener implements View.OnClickListener
    {

        @Override
        public void onClick(View view)
        {
            String filename = "names.txt";
            try
            {
                File dir = getFilesDir();
                File file = new File(dir.getPath() + filename);
                PrintWriter output = new PrintWriter(file);
                for (int ix =0; ix<listData.length; ix++)
                {
                    output.println(listData[ix]);
                }
                output.close();
            }
            catch (Exception ex)
            {}

        }
    }

    /*********************************************************************************************/
    private class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ListRow>
    {
        private final String[] mStocks;
        private int selectedItem = 0;
        LActivity parent;

        // Constructor takes an array of stock items.
        public SimpleAdapter(String[] q, LActivity p)
        {
            mStocks = q;
            parent = p;
        }

        @NonNull
        @Override
        // When a ViewHolder is created, return the holder with the View, which here is
        // the layout for an entire line of the list.
        public ListRow onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listlayout, parent, false);
            return new ListRow(v);
        }

        @Override
        // When the View is bound, it gets its data to display.  This is called
        // once for every list item.
        public void onBindViewHolder(@NonNull ListRow holder, int position)
        {
            String[] values = mStocks[position].split("\t");
            holder.mDate.setText(values[0]);
            holder.mClose.setText(values[1]);
            holder.mVolume.setText(values[2]);

            if (selectedItem == position)
                holder.itemView.setBackgroundColor(Color.CYAN);
            else
                holder.itemView.setBackgroundColor(Color.WHITE);
            //selectedItem = position;
        }

        @Override
        // Function needed to determine how many will fit on screen
        public int getItemCount()
        {
            return mStocks == null ? 0 : mStocks.length;
        }

        /**********************************************************************
         * View Holder for each row of the RecyclerView.
         */
        public class ListRow extends RecyclerView.ViewHolder implements View.OnClickListener
        {
            public TextView mDate;
            public TextView mClose;
            public TextView mVolume;

            // This constructor is called for each row and just sets up the fields
            // in the row's layout.  See onBindViewholder for how these are used.
            public ListRow(View view)
            {
                super(view);
                mDate = view.findViewById(R.id.Col1);
                mClose = view.findViewById(R.id.Col2);
                mVolume = view.findViewById(R.id.Col3);
                //???view.setOnClickListener(this);
            }

            /****************************************************************************
             * When a RecyclerView item is clicked, save which one it was and notify the
             * parent so it can highlight the selected one and unhighlight anything that
             * might have previously been selected.
             * @param v -- the View in the RecyclerView that got clicked.
             ****************************************************************************/
            @Override
            public void onClick(View v)
            {
            /*int iPos = quizList.getChildLayoutPosition(v);
            notifyItemChanged(selectedItem);
            selectedItem = getLayoutPosition();
            parent.setSelection(selectedItem);
            notifyItemChanged(selectedItem);*/
            }
        }
    }

}