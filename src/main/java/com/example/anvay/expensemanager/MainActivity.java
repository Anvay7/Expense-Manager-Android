package com.example.anvay.expensemanager;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    Button budget,categories,statistics,exit;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pd = new ProgressDialog(this);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setCancelable(false);



        Thread t=new Thread(){
            public void run() {
                try {

                        Thread.sleep(2500);



                        pd.dismiss();

                }catch(Exception e){

                }
            }

        };
        t.start();
        pd.show();

        budget=(Button)findViewById(R.id.button4);
        categories=(Button)findViewById(R.id.button3);
        statistics=(Button)findViewById(R.id.button5);
        exit=(Button)findViewById(R.id.button6);

        budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Budget.class);
                startActivity(i);
            }
        });

        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Categories.class);
                startActivity(i);
            }
        });

        statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Statistics.class);
                startActivity(i);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                b.setCancelable(false);
                b.setIcon(android.R.drawable.ic_delete);
                b.setTitle("ALERT");
                b.setMessage("Do you want to quit?");
                b.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                       finishAffinity();
                    }
                });
                b.setNegativeButton("NO",null);
                AlertDialog d=b.create();
                d.show();


            }
        });
    }



}
