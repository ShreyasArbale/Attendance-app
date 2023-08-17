package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Take_Atte_TYB extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private DatePickerDialog datePickerDialog11;
    private Button date_take_atte_tyb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_atte_tyb);

        initDatePicker();
        date_take_atte_tyb = findViewById(R.id.date_Take_TYB);
        date_take_atte_tyb.setText(getTodaysDate());
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
                    date_take_atte_tyb.setText(date);
                }
            };

            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            int style = AlertDialog.THEME_HOLO_LIGHT;

            datePickerDialog11 = new DatePickerDialog(this,style,dateSetListener,year,month,day);
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
            datePickerDialog11.show();
        }

        Button time1_take_atte_tyb;
        TextView tv13;
        Button time2_take_atte_tyb;
        TextView tv14;


        public void time1(View v) {

            time1_take_atte_tyb = findViewById(R.id.time1_Take_TYB);
            tv13 = findViewById(R.id.Take_TYA_tv3);

            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                    tv13.setText(hourOfDay + ":" + minute);
                }
            },hour, minute ,false);
            timePickerDialog.show();
        }

        public void time2(View v) {

            time2_take_atte_tyb = findViewById(R.id.time2_Take_TYA);
            tv14 = findViewById(R.id.Take_TYA_tv4);

            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                    tv14.setText(hourOfDay + ":" + minute);
                }
            }, hour, minute, false);
            timePickerDialog.show();
        }
        private void Spinner() {
            android.widget.Spinner spinner = findViewById(R.id.spinner2);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Lecture, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);


        }


        public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

        }


        public void onNothingSelected(AdapterView<?> adapterView) {

        }

    }
