package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }
    public void select1(View view){
        Intent intent = new Intent(MainActivity2.this,TY_A.class);
        startActivity(intent);
    }
    public void select2(View view){
        Intent intent = new Intent(MainActivity2.this,TY_B.class);
        startActivity(intent);
    }
    public void select3(View view){
        Intent intent = new Intent(MainActivity2.this,SY_A.class);
        startActivity(intent);
    }
    public void select4(View view){
        Intent intent = new Intent(MainActivity2.this,SY_B.class);
        startActivity(intent);
    }
}