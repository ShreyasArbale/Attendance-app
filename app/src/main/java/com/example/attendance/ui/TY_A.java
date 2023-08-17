package com.example.attendance.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.attendance.R;

public class TY_A extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ty_a);
    }
    public void TakeAtteTYA(View view){
        Intent intent = new Intent(TY_A.this,Take_Atte_TYA.class);
        startActivity(intent);
    }

    public void ViewAttendance(View view){
        Intent intent = new Intent(getApplicationContext(), DatesActivity.class);
        intent.putExtra("division", "TYA");
        startActivity(intent);
    }

}