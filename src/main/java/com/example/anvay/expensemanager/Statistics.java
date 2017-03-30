package com.example.anvay.expensemanager;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Statistics extends AppCompatActivity {
    SharedPreferences sp,sp1,sp2;
    TextView view,view1,view2;
    Button back;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        view=(TextView)findViewById(R.id.textView22);
        view1=(TextView)findViewById(R.id.textView23);
        view2=(TextView)findViewById(R.id.textView24);

        Intent i=new Intent(Statistics.this,Statistics.class);
        PendingIntent pi=PendingIntent.getActivity(Statistics.this,0,i,0);
        Notification n=new Notification.Builder(this).setContentIntent(pi).build();
        sp=getSharedPreferences("MY",MODE_PRIVATE);
        view.setText(sp.getString("username",""));//for budget

        Intent in=new Intent(Statistics.this,Statistics.class);
        PendingIntent pin=PendingIntent.getActivity(Statistics.this,0,in,0);
        Notification ni=new Notification.Builder(this).setContentIntent(pin).build();
        sp1= getSharedPreferences("NY", MODE_PRIVATE);
        view1.setText(sp1.getString("username",""));// for total

        Intent inte=new Intent(Statistics.this,Statistics.class);
        PendingIntent pint=PendingIntent.getActivity(Statistics.this,0,inte,0);
        Notification nit=new Notification.Builder(this).setContentIntent(pint).build();
        sp2= getSharedPreferences("SY", MODE_PRIVATE);
        view2.setText(sp2.getString("username2",""));

        view2.setBackgroundColor(Color.LTGRAY);

        back=(Button)findViewById(R.id.button7);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Statistics.this,MainActivity.class);
                startActivity(i);
                Statistics.this.finish();
            }
        });


    }
}
