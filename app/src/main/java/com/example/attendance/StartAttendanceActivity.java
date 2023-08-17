package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.attendance.databinding.ActivityStartAttendanceBinding;
import com.example.attendance.model.AttendanceModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class StartAttendanceActivity extends AppCompatActivity {

    private ActivityStartAttendanceBinding binding;
    private int rollNo = 1;
    private int lastRollNo = 10;

    private DatabaseReference databaseReference;
    private ArrayList<AttendanceModel> attendanceModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartAttendanceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseReference = FirebaseDatabase.getInstance().getReference();
        attendanceModels = new ArrayList<>();

        databaseReference.child("Attendance").child("TYA").setValue("attendanceModels");

        binding.buttonRollNoAbsent.setOnClickListener(v -> {
            if (rollNo>=lastRollNo){
                binding.textViewRollNo.setText("Done!");
                addDataToFirebase();
            }
            else {
                rollNo++;
                attendanceModels.add(new AttendanceModel(String.valueOf(rollNo), "10-11-2022", "a", "ab",
                        "Absent", "AGP", "A"));
                setRollNo();
            }
        });

        binding.buttonRollNoPresent.setOnClickListener(v -> {
            if (rollNo>=lastRollNo){
                binding.textViewRollNo.setText("Done!");
                addDataToFirebase();
            }
            else {
                rollNo++;
                attendanceModels.add(new AttendanceModel(String.valueOf(rollNo), "10-11-2022", "a", "ab",
                        "Present", "AGP", "A"));
                setRollNo();
            }
        });



    }

    private void setRollNo(){
        binding.textViewRollNo.setText(rollNo + "");
    }

    private void addDataToFirebase(){
        databaseReference.child("Attendance").child("TYA").setValue(attendanceModels);
    }

}