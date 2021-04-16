package com.usu.josephditton.journal.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.usu.josephditton.journal.R;

public class JournalEntriesFragment extends Fragment {
    public JournalEntriesFragment() {
        super(R.layout.fragment_journal_entries);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.fab).setOnClickListener((button) -> {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_view, NewJournalEntryFragment.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });
    }
}