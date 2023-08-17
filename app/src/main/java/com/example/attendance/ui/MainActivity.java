package com.example.attendance.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.attendance.R;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText etMain1,etMain2;
    Button btMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FirebaseDatabase.getInstance().getReference("Test1").child("Test").setValue("someValue");

        etMain1=findViewById(R.id.etMain1);
        etMain2=findViewById(R.id.etMain2);

    }
    public void Login(View view){
        String  a = "sitcoe";
        int b = 2022, d;
        String c;
        d = Integer.parseInt(etMain2.getText().toString());
        c=etMain1.getText().toString();

        if(c.equals(a) && d==b){
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
            }

        else if(!c.equals(a)){
            Toast.makeText(MainActivity.this,"Username is Incorrect",Toast.LENGTH_LONG).show();
        }

        else if(c.equals(a) && d!=b){
            Toast.makeText(MainActivity.this,"Password is Incorrect",Toast.LENGTH_LONG).show();
        }
    }
}