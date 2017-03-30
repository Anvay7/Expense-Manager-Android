package com.example.anvay.expensemanager;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Categories extends AppCompatActivity {
    Button button2;
    int net, total;
    SharedPreferences sp1,sp2,sp3;

    EditText food,entertainment,laundry,mobile,electricity,transportation,fuel,shopping,holiday,kids,sports,gifts,others,budg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        sp1 = getSharedPreferences("NY", MODE_PRIVATE);
        sp2 = getSharedPreferences("SY", MODE_PRIVATE);

        button2=(Button)findViewById(R.id.button2);
        food=(EditText)findViewById(R.id.editText2);
        entertainment=(EditText)findViewById(R.id.editText3);
        laundry=(EditText)findViewById(R.id.editText4);
        mobile=(EditText)findViewById(R.id.editText5);
        electricity=(EditText)findViewById(R.id.editText6);
        transportation=(EditText)findViewById(R.id.editText7);
        fuel=(EditText)findViewById(R.id.editText8);
        shopping=(EditText)findViewById(R.id.editText9);
        holiday=(EditText)findViewById(R.id.editText10);
        kids=(EditText)findViewById(R.id.editText11);
        sports=(EditText)findViewById(R.id.editText12);
        gifts=(EditText)findViewById(R.id.editText13);
        others=(EditText)findViewById(R.id.editText14);
        budg=(EditText)findViewById(R.id.editText18);

        Intent ins=new Intent(Categories.this,Categories.class);
        PendingIntent pins=PendingIntent.getActivity(Categories.this,0,ins,0);
        Notification nis=new Notification.Builder(this).setContentIntent(pins).build();
        sp3= getSharedPreferences("MY", MODE_PRIVATE);
        budg.setText(sp3.getString("username3",""));// from budget










        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int bg=Integer.valueOf(budg.getText().toString());
                int a=Integer.valueOf(food.getText().toString());
                int b=Integer.valueOf(entertainment.getText().toString());
                int c=Integer.valueOf(laundry.getText().toString());
                int d=Integer.valueOf(mobile.getText().toString());
                int e=Integer.valueOf(electricity.getText().toString());
                int f=Integer.valueOf(transportation.getText().toString());
                int g=Integer.valueOf(shopping.getText().toString());
                int h=Integer.valueOf(holiday.getText().toString());
                int i=Integer.valueOf(kids.getText().toString());
                int j=Integer.valueOf(sports.getText().toString());
                int k=Integer.valueOf(gifts.getText().toString());
                int l=Integer.valueOf(others.getText().toString());
                total=a+b+c+d+e+f+g+h+i+j+k+l;
                net=(bg-total);
                SharedPreferences.Editor editor4 = sp1.edit();
                editor4.putBoolean("isTrue", true);
                editor4.putString("username", String.valueOf(total));
                editor4.commit();

                SharedPreferences.Editor editor1 = sp2.edit();
                editor1.putBoolean("isTrue", true);
                editor1.putString("username2", String.valueOf(net));
                editor1.commit();

                Toast.makeText(getBaseContext(), "Saved", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Categories.this, MainActivity.class);

                startActivity(intent);
                Categories.this.finish();

            }
        });
    }
}
