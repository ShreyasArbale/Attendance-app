package com.example.attendance.model;

public class AttendanceModel {
    String roll_number;
    String date;
    String time_from;
    String time_to;
    String status;
    String subject;
    String class_division;

    public AttendanceModel(){

    }

    public AttendanceModel(String roll_number, String date, String time_from, String time_to, String status, String subject, String class_division) {
        this.roll_number = roll_number;
        this.date = date;
        this.time_from = time_from;
        this.time_to = time_to;
        this.status = status;
        this.subject = subject;
        this.class_division = class_division;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime_from() {
        return time_from;
    }

    public void setTime_from(String time_from) {
        this.time_from = time_from;
    }

    public String getTime_to() {
        return time_to;
    }

    public void setTime_to(String time_to) {
        this.time_to = time_to;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getClass_division() {
        return class_division;
    }

    public void setClass_division(String class_division) {
        this.class_division = class_division;
    }
}
