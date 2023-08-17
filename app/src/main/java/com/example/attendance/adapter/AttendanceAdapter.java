package com.example.attendance.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendance.R;
import com.example.attendance.listeners.OnFetchAttendanceData;
import com.example.attendance.model.AttendanceModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class AttendanceAdapter extends FirebaseRecyclerAdapter<AttendanceModel, AttendanceAdapter.AttendanceViewHolder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */

    private OnFetchAttendanceData onFetchAttendanceData;
    public AttendanceAdapter(@NonNull FirebaseRecyclerOptions<AttendanceModel> options, OnFetchAttendanceData onFetchAttendanceData) {
        super(options);
        this.onFetchAttendanceData = onFetchAttendanceData;
    }

    @NonNull
    @Override
    public AttendanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_attendance_layout, parent, false);
        return new AttendanceViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull AttendanceViewHolder holder, int position, @NonNull AttendanceModel model) {
        holder.rollNo.setText(model.getRoll_number());
        holder.flag.setText(model.getStatus());
        onFetchAttendanceData.onDataFetch(getItem(0));
    }

    public class AttendanceViewHolder extends RecyclerView.ViewHolder {
        TextView rollNo, flag;
        public AttendanceViewHolder(@NonNull View itemView) {
            super(itemView);
            rollNo = itemView.findViewById(R.id.text_view_roll_no);
            flag = itemView.findViewById(R.id.text_view_flag);
        }
    }
}
