package com.example.attendance.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.attendance.R;
import com.example.attendance.adapter.DateAdapter;
import com.example.attendance.listeners.OnItemClickListener;
import com.example.attendance.model.DateModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class DatesActivity extends AppCompatActivity implements OnItemClickListener {

    RecyclerView recyclerView;
    DateAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dates);
        recyclerView = findViewById(R.id.recyclerDate);

        String division = getIntent().getStringExtra("division");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<DateModel> recyclerOptions = new FirebaseRecyclerOptions.Builder<DateModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference("Attendance").child(division), DateModel.class)
                .build();

        adapter = new DateAdapter(recyclerOptions, "DATE", this);
        recyclerView.setAdapter(adapter);

        adapter.startListening();

    }

    @Override
    public void onDateClick(String date) {
        Intent intent = new Intent(getApplicationContext(), SubjectActivity.class);
        intent.putExtra("division", "TYA");
        intent.putExtra("date", date);
        startActivity(intent);
    }

    @Override
    public void onSubjectClick(String subject) {

    }
}