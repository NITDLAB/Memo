package com.hpr.ac.dev.labtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button bt_add;
    EditText et_memo;
    ListView lt_memo_list;

    ArrayList memo_arr=new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_memo=findViewById(R.id.et_memo_text);
        lt_memo_list=findViewById(R.id.lv_memo_list);

        lt_memo_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView tv= (TextView)view;

                String s=tv.getText().toString();
                Log.d("MEMO : ", s);
            }
        });
    }

    public void onADD(View v) {

        String str=et_memo.getText().toString();

        memo_arr.add(str);

//        for (Object mm : memo_arr) {
//
//            Log.d("MEMO : ", (String)mm);
//        }

        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,memo_arr);
        lt_memo_list.setAdapter(adapter);

        Toast toast = Toast.makeText(getApplicationContext(),"Memo Added",Toast.LENGTH_SHORT);
        toast.show();
    }
}
