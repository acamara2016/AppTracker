package com.example.softwareen.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.softwareen.R;
import com.example.softwareen.objects.Substance;
import com.example.softwareen.api.SubstanceRetrieverFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Adama Camara
 *
 * Recycler View adapter for displaying events in a list layout
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    List<Substance> data = new ArrayList<Substance>();

    public ListAdapter(Context context) {

        //data = SubstanceRetrieverFactory.getInstance(context).getSubstance();
        data.add(new Substance("Substance_1","2"));
        data.add(new Substance("Substance_2","2"));
        data.add(new Substance("Substance_3","2"));
        data.add(new Substance("Substance_4","2"));
        data.add(new Substance("Substance_5","2"));
        data.add(new Substance("Substance_6","2"));
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.substance_recyclerview_list_item, parent, false);
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
        private TextView substanceNameView;

        private ListViewHolder(View itemView) {
            super(itemView);
            substanceNameView = itemView.findViewById(R.id.substance_name);
            itemView.setOnClickListener(this);
        }

        private void bindView(int position) {
            Substance substance = data.get(position);
            substanceNameView.setText(substance.getName());
            System.out.println(substance.getName());
        }

        public void onClick(View view){
            //TODO: Open the EventDetailFragment when implemented
        }
    }
}
