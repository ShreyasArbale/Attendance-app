package com.example.attendance.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendance.R;
import com.example.attendance.adapter.SubjectAdapter;
import com.example.attendance.listeners.OnItemClickListener;
import com.example.attendance.model.DateModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class SubjectActivity extends AppCompatActivity implements OnItemClickListener {

    RecyclerView recyclerView;
    SubjectAdapter adapter;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        recyclerView = findViewById(R.id.recycler_subject);

        String division = getIntent().getStringExtra("division");
        date = getIntent().getStringExtra("date");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<DateModel> recyclerOptions = new FirebaseRecyclerOptions.Builder<DateModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference("Attendance").child(division).child(date), DateModel.class)
                .build();

        adapter = new SubjectAdapter(recyclerOptions, "SUBJECT", this);
        recyclerView.setAdapter(adapter);

        adapter.startListening();

    }

    @Override
    public void onDateClick(String date) {

    }

    @Override
    public void onSubjectClick(String subject) {
        Intent intent = new Intent(getApplicationContext(), ViewRollNoAttendanceActivity.class);
        intent.putExtra("division", "TYA");
        intent.putExtra("date", date);
        intent.putExtra("subject", subject);
        startActivity(intent);
    }
}