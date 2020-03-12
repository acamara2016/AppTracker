package com.example.softwareen.impl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.softwareen.R;
import com.example.softwareen.classes.Substance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mahir & Asif
 *
 * Recycler View adapter for displaying events in a list layout
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    List<Substance> data = new ArrayList<>();

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.bindView(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView subs_name_view, subs_amount_view;

        private ListViewHolder(View itemView) {
            super(itemView);
            subs_amount_view = itemView.findViewById(R.id.subs_amount_list_item);
            subs_name_view = itemView.findViewById(R.id.substance_name_list_item);
           // eventImageView = itemView.findViewById(R.id.event_image);
            itemView.setOnClickListener(this);
        }

        private void bindView(int position) {
            Substance s = data.get(position);
            subs_name_view.setText(s.getName());
            subs_amount_view.setText(String.valueOf(s.getAmount()));
            //Picasso.get().load(s.get).fit().centerCrop().into(eventImageView);
        }

        public void onClick(View view){
            //TODO: Open the EventDetailFragment when implemented
        }
    }
}
