package com.example.attendance.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.attendance.databinding.ActivityStartAttendanceBinding;
import com.example.attendance.model.AttendanceModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class StartAttendanceActivity extends AppCompatActivity {

    private ActivityStartAttendanceBinding binding;
    private int rollNo = 1;
    private int lastRollNo = 10;

    private DatabaseReference databaseReference;
    private ArrayList<AttendanceModel> attendanceModels;
    private HashMap<String, AttendanceModel> hashMap;

    private String date, startTime, endTime, subject, division;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartAttendanceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseReference = FirebaseDatabase.getInstance().getReference();
        attendanceModels = new ArrayList<>();

        hashMap = new HashMap<>();

        date = getIntent().getStringExtra("date");
        division = getIntent().getStringExtra("division");
        startTime = getIntent().getStringExtra("from");
        endTime = getIntent().getStringExtra("to");
        subject = getIntent().getStringExtra("subject");

//        databaseReference.child("Attendance").child("TYA").setValue("attendanceModels");

        binding.buttonRollNoAbsent.setOnClickListener(v -> {
            if (rollNo>=lastRollNo){
                binding.textViewRollNo.setText("Done!");
                addDataToFirebase();
            }
            else {
//                attendanceModels.add(new AttendanceModel(String.valueOf(rollNo), date, startTime, endTime,
//                        "Absent", subject, division));
                hashMap.put(rollNo + " ",new AttendanceModel(String.valueOf(rollNo), date, startTime, endTime,
                        "Absent", subject, division));
                rollNo++;
                setRollNo();
            }
        });

        binding.buttonRollNoPresent.setOnClickListener(v -> {
            if (rollNo>=lastRollNo){
                binding.textViewRollNo.setText("Done!");
                addDataToFirebase();
            }
            else {
//                attendanceModels.add(new AttendanceModel(String.valueOf(rollNo), date, startTime, endTime,
//                        "Present", subject, division));
                hashMap.put(rollNo + " ",new AttendanceModel(String.valueOf(rollNo), date, startTime, endTime,
                        "Present", subject, division));
                rollNo++;
                setRollNo();
            }
        });



    }

    private void setRollNo(){
        binding.textViewRollNo.setText(rollNo + "");
    }

    private void addDataToFirebase(){
        databaseReference.child("Attendance").child(division).child(date).child(subject).setValue(hashMap);
    }

}