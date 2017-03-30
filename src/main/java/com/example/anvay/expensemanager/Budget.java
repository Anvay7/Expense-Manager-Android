package com.example.anvay.expensemanager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class Budget extends AppCompatActivity {
    TextView bud;
    Button b1;
    SharedPreferences sp,sp3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        sp = getSharedPreferences("MY", MODE_PRIVATE);
        sp3 = getSharedPreferences("MY", MODE_PRIVATE);
        bud = (TextView) findViewById(R.id.editText);
        b1 = (Button) findViewById(R.id.button);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor3 = sp3.edit();
                editor3.putBoolean("isTrue", true);
                editor3.putString("username3", bud.getText().toString()); //for Categories and expenses
                editor3.commit();


                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean("isTrue", true);
                editor.putString("username", bud.getText().toString()); //for Statistics
                editor.commit();




                Toast.makeText(getBaseContext(), "Saved", Toast.LENGTH_LONG).show();
                Intent i = new Intent(Budget.this, MainActivity.class);
                startActivity(i);
                Budget.this.finish();
            }
        });

    }
}

