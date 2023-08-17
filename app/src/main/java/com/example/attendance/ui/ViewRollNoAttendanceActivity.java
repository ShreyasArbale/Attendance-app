package com.example.attendance.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.attendance.R;
import com.example.attendance.adapter.AttendanceAdapter;
import com.example.attendance.listeners.OnFetchAttendanceData;
import com.example.attendance.model.AttendanceModel;
import com.example.attendance.model.DateModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ViewRollNoAttendanceActivity extends AppCompatActivity implements OnFetchAttendanceData {

    RecyclerView recyclerView;
    AttendanceAdapter adapter;
    TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_roll_no_attendance);
        time = findViewById(R.id.startTimeView);

        recyclerView = findViewById(R.id.recycler_view_attendance);

        String division = getIntent().getStringExtra("division");
        String date = getIntent().getStringExtra("date");
        String sub = getIntent().getStringExtra("subject");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<AttendanceModel> recyclerOptions = new FirebaseRecyclerOptions.Builder<AttendanceModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference("Attendance").child(division).child(date).child(sub), AttendanceModel.class)
                .build();

        adapter = new AttendanceAdapter(recyclerOptions, this);
        recyclerView.setAdapter(adapter);

        adapter.startListening();

    }

    @Override
    public void onDataFetch(AttendanceModel model) {
        // TODO
    }
}