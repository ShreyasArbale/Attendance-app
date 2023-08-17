package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SY_A extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sy_a);
    }
    public void TakeAtteSYA(View view){
        Intent intent = new Intent(SY_A.this,Take_Atte_SYA.class);
        startActivity(intent);
    }
}