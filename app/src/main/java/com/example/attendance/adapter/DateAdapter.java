package com.example.attendance.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendance.R;
import com.example.attendance.listeners.OnItemClickListener;
import com.example.attendance.model.DateModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class DateAdapter extends FirebaseRecyclerAdapter<DateModel, DateAdapter.DateViewHolder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */

    private String type;
    private OnItemClickListener itemClickListener;
    public DateAdapter(@NonNull FirebaseRecyclerOptions<DateModel> options, String type, OnItemClickListener itemClickListener) {
        super(options);
        this.type = type;
        this.itemClickListener = itemClickListener;
    }


    @NonNull
    @Override
    public DateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_date_layout, parent, false);
        return new DateViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull DateViewHolder holder, int position, @NonNull DateModel model) {
        String item = getRef(position).getKey();
        holder.date.setText(item);

        holder.itemView.setOnClickListener(v -> {
                itemClickListener.onDateClick(item);
        });

    }

    public class DateViewHolder extends RecyclerView.ViewHolder {
        TextView date;
        public DateViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.text_view_date_or_subject);
        }
    }
}
