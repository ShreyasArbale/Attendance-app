package com.example.attendance.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.attendance.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Take_Atte_TYA<time1_take_atte_tya> extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private DatePickerDialog datePickerDialog;
    private Button date_take_atte_tya;
    String subject = "", from = "", to = "";
    Spinner spinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_atte_tya);

        initDatePicker();
        date_take_atte_tya = findViewById(R.id.date_Take_TYA);
        date_take_atte_tya.setText(getTodaysDate());
        Spinner();


    }

    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day,month,year);
    }

    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month+1;
                String date = makeDateString(day,month,year);
                date_take_atte_tya.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this,style,dateSetListener,year,month,day);
    }

    private String makeDateString(int day, int month, int year) {
        return day + " " +  getMonthFormat(month) + " " + year;
    }

    private String getMonthFormat(int month) {


        if (month == 1)
            return "Jan";
        if (month == 2)
            return "Feb";
        if (month == 3)
            return "Mar";
        if (month == 4)
            return "Apr";
        if (month == 5)
            return "May";
        if (month == 6)
            return "Jun";
        if (month == 7)
            return "July";
        if (month == 8)
            return "Aug";
        if (month == 9)
            return "Sep";
        if (month == 10)
            return "Oct";
        if (month == 11)
            return "Nov";
        if (month == 12)
            return "Dec";
        return "Jan";
    }

    public void Date(View view){
        datePickerDialog.show();
    }

    Button time1_take_atte_tya;
    TextView tv3;
    Button time2_take_atte_tya;
    TextView tv4;


    public void time1(View v) {

        time1_take_atte_tya = findViewById(R.id.time1_Take_TYA);
        tv3 = findViewById(R.id.Take_TYA_tv3);

        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                tv3.setText(hourOfDay + ":" + minute);
                from = hourOfDay + ":" + minute;
            }
        },hour, minute ,false);
        timePickerDialog.show();
    }

    public void time2(View v) {

        time2_take_atte_tya = findViewById(R.id.time2_Take_TYA);
        tv4 = findViewById(R.id.Take_TYA_tv4);

        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                tv4.setText(hourOfDay + ":" + minute);
                to = hourOfDay + ":" + minute;
            }
        }, hour, minute, false);
        timePickerDialog.show();
    }
    private void Spinner() {
        spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Lecture, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void start(View view) {
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        String formattedDate = df.format(c);

        if (from.isEmpty()){
            Toast.makeText(this, "Please select start time", Toast.LENGTH_SHORT).show();
        }
        else if (to.isEmpty()){
            Toast.makeText(this, "Please select end time", Toast.LENGTH_SHORT).show();
        }
        else if (Objects.equals(subject, "Lecture")){
            Toast.makeText(this, "Please select lecture", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(Take_Atte_TYA.this, StartAttendanceActivity.class);
            intent.putExtra("division", "TYA");
            intent.putExtra("date", formattedDate);
            intent.putExtra("subject", subject);
            intent.putExtra("from", from);
            intent.putExtra("to", to);
            startActivity(intent);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        subject = spinner.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}