package com.usu.josephditton.journal.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableList;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.usu.josephditton.journal.JournalEntriesAdapter;
import com.usu.josephditton.journal.R;
import com.usu.josephditton.journal.models.JournalEntry;
import com.usu.josephditton.journal.viewmodels.JournalEntriesViewModel;

import java.util.ArrayList;

public class JournalEntriesFragment extends Fragment {
    public JournalEntriesFragment() {
        super(R.layout.fragment_journal_entries);
    }
    JournalEntriesViewModel viewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(getActivity()).get(JournalEntriesViewModel.class);

        JournalEntriesAdapter adapter = new JournalEntriesAdapter(
                viewModel.getEntries(),
                (entry) -> {
                    Log.d("Journal Entry", entry.id + "");
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container_view, NewJournalEntryFragment.class, null)
                            .setReorderingAllowed(true)
                            .addToBackStack(null)
                            .commit();
                }
        );
        viewModel.getEntries().addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList<JournalEntry>>() {
            @Override
            public void onChanged(ObservableList<JournalEntry> sender) {
                getActivity().runOnUiThread(() -> {
                   adapter.notifyDataSetChanged();
                });
            }

            @Override
            public void onItemRangeChanged(ObservableList<JournalEntry> sender, int positionStart, int itemCount) {
                getActivity().runOnUiThread(() -> {
                    adapter.notifyItemRangeChanged(positionStart, itemCount);
                });
            }

            @Override
            public void onItemRangeInserted(ObservableList<JournalEntry> sender, int positionStart, int itemCount) {
                getActivity().runOnUiThread(() -> {
                    adapter.notifyItemRangeInserted(positionStart, itemCount);
                });
            }

            @Override
            public void onItemRangeMoved(ObservableList<JournalEntry> sender, int fromPosition, int toPosition, int itemCount) {
//                getActivity().runOnUiThread(() -> {
//                    adapter.notifyDataSetChanged();
//                });
            }

            @Override
            public void onItemRangeRemoved(ObservableList<JournalEntry> sender, int positionStart, int itemCount) {
//                getActivity().runOnUiThread(() -> {
//                    adapter.notifyDataSetChanged();
//                });
            }
        });
        RecyclerView recyclerView = view.findViewById(R.id.journal_entries);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        view.findViewById(R.id.fab).setOnClickListener((button) -> {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_view, NewJournalEntryFragment.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });
    }
}