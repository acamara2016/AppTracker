package com.example.softwareen.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    FirebaseHandler fb = new FirebaseHandler();
    private ListView listView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        listView = root.findViewById(R.id.subsList);
        List<Substance> subsList = fb.retrieveConsumedSubstance(fb.retrieveCurrentUID(),7);
        ArrayAdapter<Substance> adapter = new ArrayAdapter<Substance>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                subsList
        );
        listView.setAdapter(adapter);
        //ArrayAdapter<Substance> adapter = new ArrayAdapter<Substance>(this,R.layout.list_view_item,R.id.textView, subsList);
        return root;
    }
}