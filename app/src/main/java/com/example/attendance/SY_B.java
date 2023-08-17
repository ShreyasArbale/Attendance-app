package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SY_B extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sy_b);
    }
    public void TakeAtteSYB(View view){
        Intent intent = new Intent(SY_B.this,Take_Atte_SYB.class);
        startActivity(intent);
    }
}