package com.usu.josephditton.journal.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.usu.josephditton.journal.R;
import com.usu.josephditton.journal.viewmodels.JournalEntriesViewModel;

public class CreateOrUpdateJournalEntryFragment extends Fragment {
    public CreateOrUpdateJournalEntryFragment() {
        super(R.layout.fragment_new_journal_entry);
    }
    JournalEntriesViewModel viewModel;
    private boolean saving = false;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        viewModel = new ViewModelProvider(getActivity()).get(JournalEntriesViewModel.class);

        viewModel.getCurrentEntry().observe(getViewLifecycleOwner(), entry -> {
            if (entry != null) {
                TextInputEditText titleInput = view.findViewById(R.id.title_input);
                TextInputEditText bodyInput = view.findViewById(R.id.body_input);
                titleInput.setText(entry.title);
                bodyInput.setText(entry.body);
            }
        });

        viewModel.getSaving().observe(getViewLifecycleOwner(), saving -> {
            if (this.saving && !saving) {
                // go back be done
                getActivity().runOnUiThread(() -> {
                    getActivity().getSupportFragmentManager().popBackStack();
                });
            } else if(!this.saving && saving) {
                MaterialButton button = view.findViewById(R.id.save_button);
                button.setEnabled(false);
            }
            this.saving = saving;
        });
        TextInputEditText titleInput = view.findViewById(R.id.title_input);
        TextInputEditText bodyInput = view.findViewById(R.id.body_input);
        view.findViewById(R.id.save_button).setOnClickListener(button -> {
            viewModel.saveJournalEntry(titleInput.getText().toString(), bodyInput.getText().toString());
        });
    }
}