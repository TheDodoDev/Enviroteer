package com.enviroteer.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.enviroteer.MainActivity;
import com.enviroteer.R;
import com.enviroteer.ui.Detail;
import com.enviroteer.ui.DetailStorage;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        DetailStorage detailStorage = new DetailStorage();
        recyclerView.setAdapter(new MyAdapter(view.getContext(), detailStorage.getDetails()));

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}