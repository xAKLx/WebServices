package com.example.xaklx.myapplication;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String rslt="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView)findViewById(R.id.textView);
                EditText et = (EditText)findViewById(R.id.editText);

                Caller c=new Caller(); c.celsius = et.getText().toString();

                try {
                    c.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                c.start();

                while(c.isAlive()) {
                    try {
                        Thread.sleep(10);
                    }catch(Exception ex) {
                    }
                }

                tv.setText(rslt);

            }
        });
    }
}
