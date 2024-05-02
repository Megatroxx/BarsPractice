package com.example.barspractice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.barspractice.databinding.FragmentSelectedBinding;

import java.util.ArrayList;
import java.util.List;
public class SelectedFragment extends Fragment {

    FragmentSelectedBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSelectedBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NewsClass firstEconomic = new NewsClass(R.drawable.reshet, "Решетников нашел в ФНБ дополнительные деньги на проекты",
                "10:00 AM");

        NewsClass secondEconomic = new NewsClass(R.drawable.arbeit, "Министр труда ответил на заявления о конце дешевого труда в России",
                "17:52 PM");

        NewsClass thirdEconomic = new NewsClass(R.drawable.siluanov, "Силуанов заявил, что в России назрела «донастройка» налогов",
                "14:22 PM");


        List<NewsClass> SelectedNews = new ArrayList<>();

        SelectedNews.add(firstEconomic);
        SelectedNews.add(secondEconomic);
        SelectedNews.add(thirdEconomic);

        RecyclerView recyclerView = binding.economicRecycler;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        NewsAdapter economicAdapter = new NewsAdapter(getContext(), SelectedNews);
        recyclerView.setAdapter(economicAdapter);
        economicAdapter.notifyDataSetChanged();
    }
}