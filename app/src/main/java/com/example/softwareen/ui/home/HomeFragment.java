package com.example.softwareen.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.softwareen.R;
import com.example.softwareen.db.FirebaseHandler;
import com.example.softwareen.objects.Substance;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();
    private Button refresh_button;
    FirebaseHandler fb = new FirebaseHandler();
    private ListView listView;
    String uid;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        refresh_button = root.findViewById(R.id.refresh_button);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(fb.giveDate());
            }
        });
        listView = root.findViewById(R.id.subsList);
        final List<Substance> subsList = fb.retrieveConsumedSubtance();
        final ArrayAdapter<Substance> adapter = new ArrayAdapter<Substance>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                subsList
        );
        listView.setAdapter(adapter);
        refresh_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               listView.setAdapter(adapter);
            }
        });
        //ArrayAdapter<Substance> adapter = new ArrayAdapter<Substance>(this,R.layout.list_view_item,R.id.textView, subsList);
        return root;
    }
    private List<Substance> retrieveConsumedSubtance() {
        ref = FirebaseDatabase.getInstance().getReference().child("user").child(uid).child("consumedList").child(fb.giveDate());
        final List<Substance> subslist = new ArrayList<Substance>();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                for (DataSnapshot userSnapshot: dataSnapshot.getChildren()) {
                    Substance s = new Substance();
                    s.setName((String) userSnapshot.child("name").getValue());
                    s.setAmount((Long) userSnapshot.child("amount").getValue());
                    System.out.println(s.toString());
                    subslist.add(s);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return subslist;
    }

}